package net.cd.service.kernal.impl;

import net.cd.dto.kernal.*;
import net.cd.dto.xtras.CdXKvDto;
import net.cd.exception.CdErrors;
import net.cd.exception.CdException;
import net.cd.jpa.entity.kernal.CdKAssetEntity;
import net.cd.repository.kernal.CdKAssetRepository;
import net.cd.service.kernal.CdKAssetService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vincent on 05/12/2017.
 */
@Service
public class CdKAssetServiceImpl implements CdKAssetService {

    @Autowired
    private CdKAssetRepository cdKAssetRepository;

    @Autowired
    @Value("#{cdPathAsset}")
    private String cdPathAsset;

    @Override
    public CdKAssetDto findOne(Integer id) {
        CdKAssetDto dto = new CdKAssetDto();
        new ModelMapper().map(cdKAssetRepository.findOne(id), dto);
        return dto;
    }

    @Override
    public CdKAssetDto findByReference(String reference) {
        CdKAssetDto dto = new CdKAssetDto();
        CdKAssetEntity cdKAssetEntity = cdKAssetRepository.findFirstByReference(reference);
        if (cdKAssetEntity != null) {
            new ModelMapper().map(cdKAssetEntity, dto);
            return dto;
        }
        return null;
    }

    @Override
    public List<CdKAssetDto> findAll() {
        return map(cdKAssetRepository.findAll());
    }

    @Override
    public List<CdKAssetDto> findAllByIdIn(List<Integer> idList) {
        return map(cdKAssetRepository.findAllByIdInAndPurgedIsNull(idList));
    }

    @Override
    public List<CdKAssetDto> findAllByPurgedIsNull() {
        return map(cdKAssetRepository.findAllByPurgedIsNullOrderByMadeDesc());
    }

    @Override
    public CdKAssetDto save(CdKAssetDto cdKAssetDto) {
        ModelMapper mapper = new ModelMapper();
        CdKAssetEntity cdKAssetEntity = new CdKAssetEntity();
        mapper.map(cdKAssetDto, cdKAssetEntity);
        mapper.map(cdKAssetRepository.save(cdKAssetEntity), cdKAssetDto);
        return cdKAssetDto;
    }

    @Override
    @Transactional
    public List<CdKAssetDto> saveAll(List<CdKAssetDto> cdKAssetDtoList) {
        return map(cdKAssetRepository.save(mapReversed(cdKAssetDtoList)));
    }

    private List<CdKAssetDto> map(List<CdKAssetEntity> source) {
        ModelMapper mapper = new ModelMapper();
        ArrayList<CdKAssetDto> rtn = new ArrayList<>();
        source.stream().map((entity) -> {
            CdKAssetDto dto = new CdKAssetDto();
            mapper.map(entity, dto);
            return dto;
        }).forEachOrdered((dto) -> {
            rtn.add(dto);
        });
        return rtn;
    }

    private List<CdKAssetEntity> mapReversed(List<CdKAssetDto> source) {
        ModelMapper mapper = new ModelMapper();
        ArrayList<CdKAssetEntity> rtn = new ArrayList<>();
        source.stream().map((dto) -> {
            CdKAssetEntity entity = new CdKAssetEntity();
            mapper.map(dto, entity);
            return entity;
        }).forEachOrdered((entity) -> {
            rtn.add(entity);
        });
        return rtn;
    }

    @Override
    public CdXKvDto buildOpKAssetPath(Object opKAnyDto) throws CdException {
        int id;
        String folder = cdPathAsset + File.separator;

        if (opKAnyDto.getClass().equals(CdKMemberDto.class)) {
            id = ((CdKMemberDto)opKAnyDto).getId();
            folder += "VnKMember" + File.separator + id;
        } else {
            throw new CdException(CdErrors.CD_K_ASSET_TYPE_NOT_DETERMINES);
        }

        return new CdXKvDto(id, null, folder);
    }

    @Override
    public void putOpKAssetFile(CdKAssetDto cdKAssetDto, Object opKAnyDto, String folderId, String name) throws IOException {
        Integer id = 0;
        String folder = cdPathAsset;
        try {
            CdXKvDto cdXKvDto = buildOpKAssetPath(opKAnyDto);
            id = cdXKvDto.getId();
            folder = cdXKvDto.getV();
            if (!new File(folder).exists()) {
                new File(folder).mkdirs();
            }
        } catch (CdException e) {
            e.printStackTrace();
        }

        File file = new File(cdPathAsset + File.separator + cdKAssetDto.getReference());
        File dest = new File(folder + File.separator + id+"-"+ cdKAssetDto.getId());
        Files.move(Paths.get(file.getCanonicalPath()), Paths.get(folder).resolve(id+"-"+ cdKAssetDto.getId()), StandardCopyOption.REPLACE_EXISTING);

        java.nio.file.Files.createSymbolicLink(Paths.get(cdPathAsset + File.separator + "VnKAny" + File.separator + cdKAssetDto.getReference()), Paths.get(dest.toURI()));
    }

    @Override
    public void putOpKAssetFiles(List<CdKAssetDto> cdKAssetDtoList, Object opKAnyDto, String folderId) throws IOException {
        List<Integer> idList = new ArrayList<>();
        for (CdKAssetDto cdKAssetDto : cdKAssetDtoList) {
            idList.add(cdKAssetDto.getId());
        }
        cdKAssetDtoList = findAllByIdIn(idList);
        CdXKvDto cdXKvDto = buildOpKAssetPath(opKAnyDto);

        for (CdKAssetDto cdKAssetDto : cdKAssetDtoList) {
            putOpKAssetFile(cdKAssetDto, opKAnyDto, folderId, cdXKvDto.getId()+"-"+ cdKAssetDto.getId()+","+ cdKAssetDto.getName());
        }
    }
}

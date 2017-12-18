package net.cd.service.xtras.impl;

import net.cd.dto.xtras.CdXManageDto;
import net.cd.jpa.entity.xtras.CdXManageEntity;
import net.cd.repository.xtras.CdXManageRepository;
import net.cd.service.xtras.CdXManageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tree.Yip on 25/6/2017.
 */
@Service
public class CdXManageServiceImpl implements CdXManageService {

    @Autowired
    private CdXManageRepository cdXManageRepository;

    @Override
    public CdXManageDto findByEmail(String email) {
        CdXManageEntity cdXManageEntity = cdXManageRepository.findByEmail(email);
        if (cdXManageEntity != null) {
            CdXManageDto cdXManageDto = new CdXManageDto();
            new ModelMapper().map(cdXManageEntity, cdXManageDto);
            return cdXManageDto;
        }
        return null;
    }

    @Override
    public List<CdXManageDto> findAll() {
        return map(cdXManageRepository.findAll());
    }

    private List<CdXManageDto> map(List<CdXManageEntity> source) {
        ModelMapper mapper = new ModelMapper();
        ArrayList<CdXManageDto> rtn = new ArrayList<>();
        for (CdXManageEntity entity: source) {
            CdXManageDto dto = new CdXManageDto();
            mapper.map(entity, dto);
            rtn.add(dto);
        }
        return rtn;
    }
}

package net.cd.service.kernal;

import net.cd.dto.kernal.CdKAssetDto;
import net.cd.dto.xtras.CdXKvDto;

import java.io.IOException;
import java.util.List;

/**
 * Created by Vincent on 05/12/2017.
 */
public interface CdKAssetService {

    CdKAssetDto findOne(Integer id);

    CdKAssetDto findByReference(String reference);

    List<CdKAssetDto> findAll();

    List<CdKAssetDto> findAllByIdIn(List<Integer> idList);

    List<CdKAssetDto> findAllByPurgedIsNull();

    CdKAssetDto save(CdKAssetDto cdKAssetDto);

    List<CdKAssetDto> saveAll(List<CdKAssetDto> cdKAssetDtoList);

    CdXKvDto buildOpKAssetPath(Object opKAnyDto) throws ClassNotFoundException;

    void putOpKAssetFile(CdKAssetDto cdKAssetDto, Object opKAnyDto, String folderId, String name) throws IOException;

    void putOpKAssetFiles(List<CdKAssetDto> cdKAssetDtoList, Object opKAnyDto, String folderId) throws IOException;
}

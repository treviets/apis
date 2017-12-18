package net.cd.service.xtras;

import net.cd.dto.xtras.CdXKvDto;

import java.util.List;

/**
 * Created by Vincent 01/12/2017
 */
public interface CdXKvService {

    List<CdXKvDto> findAll();

    List<CdXKvDto> findAllByPurgedIsNullAndEnableTrue();

    CdXKvDto save(CdXKvDto cdXKvDto);

    List<CdXKvDto> saveAll(List<CdXKvDto> cdXKvDtoList);
}

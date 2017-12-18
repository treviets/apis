package net.cd.service.xtras;

import net.cd.dto.xtras.CdXManageDto;

import java.util.List;

/**
 * Created by Vincent 01/12/2017
 */
public interface CdXManageService {

    CdXManageDto findByEmail(String email);

    List<CdXManageDto> findAll();
}

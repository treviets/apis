package net.cd.service.kernal;

import java.util.List;

import net.cd.dto.kernal.CdKAuthDto;

/**
 * Created by Vincent 01/12/2017
 */
public interface CdKAuthService {

    CdKAuthDto save(CdKAuthDto cdKAuthDto);

    List<CdKAuthDto> findAll();

    List<CdKAuthDto> findAllByPurgedIsNull();
    List<CdKAuthDto> findByMember(Integer memberId);
}

package net.cd.service.kernal;

import java.util.List;

import net.cd.dto.kernal.CdLikeDto;

/**
 * Created by Vincent 17/12/2017
 */
public interface CdLikeService {

	CdLikeDto save(CdLikeDto cdLikeDto);
    boolean delete(CdLikeDto cdLikeDto);
    List<CdLikeDto> findAll();
}
 
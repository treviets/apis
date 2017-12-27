package net.cd.service.kernal;

import java.util.List;

import net.cd.dto.kernal.CdCommentDto;

/**
 * Created by Vincent 17/12/2017
 */
public interface CdCommentService {

    CdCommentDto save(CdCommentDto cdCommentDto);
    boolean delete(CdCommentDto cdCommentDto);
    List<CdCommentDto> findAll();
}
 
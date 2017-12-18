package net.cd.service.kernal;

import java.util.List;

import net.cd.dto.kernal.CdFeedCommentDto;

/**
 * Created by Vincent 17/12/2017
 */
public interface CdFeedCommentService {

    CdFeedCommentDto save(CdFeedCommentDto cdFeedDto);
    boolean delete(CdFeedCommentDto cdFeedDto);
    List<CdFeedCommentDto> findAll();
}
 
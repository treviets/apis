package net.cd.service.kernal;

import java.util.List;

import net.cd.dto.kernal.CdFeedDto;
import net.cd.jpa.entity.kernal.CdFeedEntity;

/**
 * Created by Vincent 07/12/2017
 */
public interface CdFeedService {

    CdFeedDto save(CdFeedDto cdFeedDto);
    boolean delete(CdFeedDto cdFeedDto);
    List<CdFeedDto> findAll();
    List<CdFeedDto> findAllByPurgedIsNullAndScope(CdFeedEntity.FeedScope scope);
    List<CdFeedDto> findByAuthor(Integer authorId);
    CdFeedDto findOne(Integer feedId);
    CdFeedDto findByReference(String reference);
}
 
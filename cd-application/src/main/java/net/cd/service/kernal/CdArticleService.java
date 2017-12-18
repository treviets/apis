package net.cd.service.kernal;

import java.util.List;

import net.cd.dto.kernal.CdArticleDto;

/**
 * Created by Vincent 07/12/2017
 */
public interface CdArticleService {

    CdArticleDto save(CdArticleDto cdFeedDto);

    List<CdArticleDto> findAll();

    List<CdArticleDto> findAllByPurgedIsNull();
    CdArticleDto findOne(Integer feedId);
}
 
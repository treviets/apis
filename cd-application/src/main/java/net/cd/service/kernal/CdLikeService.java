package net.cd.service.kernal;

import java.util.List;

import net.cd.dto.kernal.CdArticleDto;
import net.cd.dto.kernal.CdKMemberDto;
import net.cd.dto.kernal.CdLikeDto;

/**
 * Created by Vincent 17/12/2017
 */
public interface CdLikeService {

	CdLikeDto save(CdLikeDto cdLikeDto);
    boolean delete(CdLikeDto cdLikeDto);
    boolean delete(List<CdLikeDto> cdLikeDto);
    List<CdLikeDto> findByAuthorAndArticleId(CdKMemberDto author, CdArticleDto articleId);
    List<CdLikeDto> findAll();
}
 
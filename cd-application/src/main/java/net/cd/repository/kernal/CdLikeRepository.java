package net.cd.repository.kernal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.cd.jpa.entity.kernal.CdKMemberEntity;
import net.cd.jpa.entity.kernal.CdLikeEntity;

/**
 * Created by Vincent 07/12/2017
 */
public interface CdLikeRepository extends JpaRepository<CdLikeEntity, Integer> {

	List<CdLikeEntity> findAllByPurgedIsNull();
	List<CdLikeEntity> findByAuthorAndArticleId(CdKMemberEntity author, Integer articleId);
}

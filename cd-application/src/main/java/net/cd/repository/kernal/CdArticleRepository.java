package net.cd.repository.kernal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.cd.jpa.entity.kernal.CdArticleEntity;

/**
 * Created by Vincent 07/12/2017
 */
public interface CdArticleRepository extends JpaRepository<CdArticleEntity, Integer> {

	List<CdArticleEntity> findAllByPurgedIsNull();
}

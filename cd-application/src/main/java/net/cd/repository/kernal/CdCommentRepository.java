package net.cd.repository.kernal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.cd.jpa.entity.kernal.CdCommentEntity;

/**
 * Created by Vincent 07/12/2017
 */
public interface CdCommentRepository extends JpaRepository<CdCommentEntity, Integer> {

	List<CdCommentEntity> findAllByPurgedIsNull();
}

package net.cd.repository.trace;

import net.cd.jpa.entity.kernal.CdKMemberEntity;
import net.cd.jpa.entity.trace.CdTVerificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Vincent 01/12/2017
 */
public interface CdTVerificationRepository extends JpaRepository<CdTVerificationEntity, Long> {

    List<CdTVerificationEntity> findByMemberOrderByMadeDesc(CdKMemberEntity member);

    List<CdTVerificationEntity> findByCodeOrderByMadeDesc(String code);
}

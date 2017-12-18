package net.cd.repository.kernal;

import java.util.List;
import net.cd.jpa.entity.kernal.CdKMemberAuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Vincent 01/12/2017
 */
public interface CdKMemberAuthRepository extends JpaRepository<CdKMemberAuthEntity, Integer> {

    List<CdKMemberAuthEntity> findAllByPurgedIsNull();
}

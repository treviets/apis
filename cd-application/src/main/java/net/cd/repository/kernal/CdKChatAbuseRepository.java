package net.cd.repository.kernal;

import java.util.List;
import net.cd.jpa.entity.kernal.CdKChatAbuseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Vincent 01/12/2017
 */
public interface CdKChatAbuseRepository extends JpaRepository<CdKChatAbuseEntity, Integer> {

    List<CdKChatAbuseEntity> findAllByPurgedIsNull();

}

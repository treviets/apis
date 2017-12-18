package net.cd.repository.kernal;

import java.util.List;
import net.cd.jpa.entity.kernal.CdKChatAttributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Vincent 01/12/2017
 */
public interface CdKChatAttributeRepository extends JpaRepository<CdKChatAttributeEntity, Integer> {

    List<CdKChatAttributeEntity> findAllByPurgedIsNull();
}

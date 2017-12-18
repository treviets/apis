package net.cd.repository.kernal;

import java.util.List;
import net.cd.jpa.entity.kernal.CdKChatGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Vincent 01/12/2017
 */
public interface CdKChatGroupRepository extends JpaRepository<CdKChatGroupEntity, Integer> {

    List<CdKChatGroupEntity> findAllByPurgedIsNull();
    List<CdKChatGroupEntity> findByIdentifier(Integer identifier);
    CdKChatGroupEntity findById(Integer id);
    CdKChatGroupEntity findByReference(String reference);
}

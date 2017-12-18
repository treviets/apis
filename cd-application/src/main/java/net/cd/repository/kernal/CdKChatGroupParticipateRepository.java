package net.cd.repository.kernal;

import java.util.List;
import net.cd.jpa.entity.kernal.CdKChatGroupParticipateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Vincent 01/12/2017
 */
public interface CdKChatGroupParticipateRepository extends JpaRepository<CdKChatGroupParticipateEntity, Integer> {

    List<CdKChatGroupParticipateEntity> findAllByPurgedIsNull();
    List<CdKChatGroupParticipateEntity> findByChatgroup(Integer chatGroupId);
    CdKChatGroupParticipateEntity findById(Integer id);
}

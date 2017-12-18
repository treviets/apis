package net.cd.repository.kernal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.cd.jpa.entity.kernal.CdKChatPinEntity;

/**
 * Created by Vincent 01/12/2017
 */
public interface CdKChatPinRepository extends JpaRepository<CdKChatPinEntity, Integer> {

    List<CdKChatPinEntity> findByMember(Integer member);
    CdKChatPinEntity findByMemberAndIdentifier(Integer member, Integer identifier);
}

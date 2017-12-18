package net.cd.repository.kernal;

import net.cd.jpa.entity.kernal.CdKMemberEntity;
import net.cd.jpa.entity.kernal.CdKMemberRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Vincent 01/12/2017
 */
public interface CdKMemberRoleRepository extends JpaRepository<CdKMemberRoleEntity, Integer> {

    List<CdKMemberRoleEntity> findByMember(CdKMemberEntity member);

    List<CdKMemberRoleEntity> findByMemberAndIdentity(CdKMemberEntity member, CdKMemberRoleEntity.MemberRoleRelativeIdentity identity);

    List<CdKMemberRoleEntity> findByIdentifierEqualsAndIdentity(Integer identifier, CdKMemberRoleEntity.MemberRoleRelativeIdentity identity);

    List<CdKMemberRoleEntity> findAllByPurgedIsNull();
}

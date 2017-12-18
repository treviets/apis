package net.cd.service.kernal;

import net.cd.dto.kernal.CdKMemberDto;
import net.cd.dto.kernal.CdKMemberRoleDto;
import net.cd.jpa.entity.kernal.CdKMemberRoleEntity;

import java.util.List;

/**
 * Created by Vincent 01/12/2017
 */
public interface CdKMemberRoleService {

    List<CdKMemberRoleDto> findByMember(CdKMemberDto member);

    List<CdKMemberRoleDto> findByMemberAndIdentity(CdKMemberDto member, CdKMemberRoleEntity.MemberRoleRelativeIdentity identity);

    List<CdKMemberRoleDto> findByIdentifierAndIdentity(Integer identifier, CdKMemberRoleEntity.MemberRoleRelativeIdentity identity);

    List<CdKMemberRoleDto> findAll();

    List<CdKMemberRoleDto> findAllByPurgedIsNull();

    CdKMemberRoleDto save(CdKMemberRoleDto cdKMemberRoleDto);
}

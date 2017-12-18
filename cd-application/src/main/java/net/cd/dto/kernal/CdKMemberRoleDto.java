package net.cd.dto.kernal;

import net.cd.jpa.entity.kernal.CdKMemberRoleEntity;

import javax.validation.constraints.NotNull;

/**
 * Created by Vincent 01/12/2017
 */
public class CdKMemberRoleDto {

    @NotNull
    private Integer id;
    private CdKMemberDto member;
    private Integer identifier;
    private CdKMemberRoleEntity.MemberRoleRelativeIdentity identity;
    private Integer active;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CdKMemberDto getMember() {
        return member;
    }

    public void setMember(CdKMemberDto member) {
        this.member = member;
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }

    public CdKMemberRoleEntity.MemberRoleRelativeIdentity getIdentity() {
        return identity;
    }

    public void setIdentity(CdKMemberRoleEntity.MemberRoleRelativeIdentity identity) {
        this.identity = identity;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}

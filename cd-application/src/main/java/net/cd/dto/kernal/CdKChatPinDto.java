package net.cd.dto.kernal;

import net.cd.jpa.entity.kernal.CdKChatPinEntity;

/**
 * Created by Vincent 01/12/2017
 */
public class CdKChatPinDto {
    private Integer id;
    private Integer member;
    private Integer identifier;
    private CdKChatPinEntity.Identity identity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMember() {
        return member;
    }

    public void setMember(Integer member) {
        this.member = member;
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }

    public CdKChatPinEntity.Identity getIdentity() {
        return identity;
    }

    public void setIdentity(CdKChatPinEntity.Identity identity) {
        this.identity = identity;
    }
}

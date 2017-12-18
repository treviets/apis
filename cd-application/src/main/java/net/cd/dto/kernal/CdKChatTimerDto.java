package net.cd.dto.kernal;

import net.cd.jpa.entity.kernal.CdKChatTimerEntity;

import java.sql.Timestamp;

/**
 * Created by Vincent 01/12/2017
 */
public class CdKChatTimerDto {
    private Integer id;
    private String reference;
    private CdKMemberDto member;
    private Integer stanza;
    private String message;
    private Timestamp stamp;
    private CdKChatTimerEntity.Action action;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public CdKMemberDto getMember() {
        return member;
    }

    public void setMember(CdKMemberDto member) {
        this.member = member;
    }

    public Integer getStanza() {
        return stanza;
    }

    public void setStanza(Integer stanza) {
        this.stanza = stanza;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getStamp() {
        return stamp;
    }

    public void setStamp(Timestamp stamp) {
        this.stamp = stamp;
    }

    public CdKChatTimerEntity.Action getAction() {
        return action;
    }

    public void setAction(CdKChatTimerEntity.Action action) {
        this.action = action;
    }
}

package net.cd.dto.kernal;

import net.cd.jpa.entity.kernal.CdKRosterEntity;

/**
 * Created by Vincent 01/12/2017
 */
public class CdKRosterDto {
    private Integer id;
    private String reference;
    private Integer member;
    private CdKMemberDto contact;
    private CdKRosterEntity.Relationship relationship;

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

    public Integer getMember() {
        return member;
    }

    public void setMember(Integer member) {
        this.member = member;
    }

    public CdKMemberDto getContact() {
        return contact;
    }

    public void setContact(CdKMemberDto contact) {
        this.contact = contact;
    }

    public CdKRosterEntity.Relationship getRelationship() {
        return relationship;
    }

    public void setRelationship(CdKRosterEntity.Relationship relationship) {
        this.relationship = relationship;
    }
}

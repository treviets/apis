package net.cd.dto.kernal;

/**
 * Created by Vincent 01/12/2017
 */
public class CdKRosterGroupContactDto {
    private Integer id;
    private String reference;
    private CdKRosterGroupDto rostergroup;
    private CdKMemberDto contact;

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

    public CdKRosterGroupDto getRostergroup() {
        return rostergroup;
    }

    public void setRostergroup(CdKRosterGroupDto rostergroup) {
        this.rostergroup = rostergroup;
    }

    public CdKMemberDto getContact() {
        return contact;
    }

    public void setContact(CdKMemberDto contact) {
        this.contact = contact;
    }
}

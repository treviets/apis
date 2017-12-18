package net.cd.dto.kernal;

/**
 * Created by Vincent on 01/12/2017.
 */
public class CdKChatAbuseDto {
    private Integer id;
    private String reference;
    private CdKMemberDto member;
    private CdKMemberDto sender;
    private String stanza;
    private String report;
    private CdKAssetDto image;

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

    public CdKMemberDto getSender() {
        return sender;
    }

    public void setSender(CdKMemberDto sender) {
        this.sender = sender;
    }

    public String getStanza() {
        return stanza;
    }

    public void setStanza(String stanza) {
        this.stanza = stanza;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public CdKAssetDto getImage() {
        return image;
    }

    public void setImage(CdKAssetDto image) {
        this.image = image;
    }
}

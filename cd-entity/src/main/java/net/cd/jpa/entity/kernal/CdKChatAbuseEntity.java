package net.cd.jpa.entity.kernal;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Tree.Yip on 19/11/2017.
 */
@Entity
@Table(name = "cd_kChatAbuse")
public class CdKChatAbuseEntity {
    private Integer id;
    private String reference;
    private CdKMemberEntity member;
    private CdKMemberEntity sender;
    private String stanza;
    private String report;
    private CdKAssetEntity image;
    private Timestamp made;
    private Timestamp revised;
    private Timestamp purged;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "reference")
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @OneToOne
    @JoinColumn(name = "member")
    public CdKMemberEntity getMember() {
        return member;
    }

    public void setMember(CdKMemberEntity member) {
        this.member = member;
    }

    @OneToOne
    @JoinColumn(name = "sender")
    public CdKMemberEntity getSender() {
        return sender;
    }

    public void setSender(CdKMemberEntity sender) {
        this.sender = sender;
    }

    @Basic
    @Column(name = "stanza")
    public String getStanza() {
        return stanza;
    }

    public void setStanza(String stanza) {
        this.stanza = stanza;
    }

    @Basic
    @Column(name = "report")
    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    @OneToOne
    @JoinColumn(name = "image")
    public CdKAssetEntity getImage() {
        return image;
    }

    public void setImage(CdKAssetEntity image) {
        this.image = image;
    }

    @Basic
    @Column(name = "made")
    public Timestamp getMade() {
        return made;
    }

    public void setMade(Timestamp made) {
        this.made = made;
    }

    @Basic
    @Column(name = "revised")
    public Timestamp getRevised() {
        return revised;
    }

    public void setRevised(Timestamp revised) {
        this.revised = revised;
    }

    @Basic
    @Column(name = "purged")
    public Timestamp getPurged() {
        return purged;
    }

    public void setPurged(Timestamp purged) {
        this.purged = purged;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CdKChatAbuseEntity that = (CdKChatAbuseEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (reference != null ? !reference.equals(that.reference) : that.reference != null) return false;
        if (member != null ? !member.equals(that.member) : that.member != null) return false;
        if (sender != null ? !sender.equals(that.sender) : that.sender != null) return false;
        if (stanza != null ? !stanza.equals(that.stanza) : that.stanza != null) return false;
        if (report != null ? !report.equals(that.report) : that.report != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (made != null ? !made.equals(that.made) : that.made != null) return false;
        if (revised != null ? !revised.equals(that.revised) : that.revised != null) return false;
        if (purged != null ? !purged.equals(that.purged) : that.purged != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (reference != null ? reference.hashCode() : 0);
        result = 31 * result + (member != null ? member.hashCode() : 0);
        result = 31 * result + (sender != null ? sender.hashCode() : 0);
        result = 31 * result + (stanza != null ? stanza.hashCode() : 0);
        result = 31 * result + (report != null ? report.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (made != null ? made.hashCode() : 0);
        result = 31 * result + (revised != null ? revised.hashCode() : 0);
        result = 31 * result + (purged != null ? purged.hashCode() : 0);
        return result;
    }
}

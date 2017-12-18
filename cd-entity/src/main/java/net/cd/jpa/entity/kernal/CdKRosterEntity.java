package net.cd.jpa.entity.kernal;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Vincent on 05/12/2017.
 */
@Entity
@Table(name = "cd_kRoster")
public class CdKRosterEntity {

    public enum Relationship {
        ROSTER, BLOCK, ABUSE
    }

    private Integer id;
    private String reference;
    private Integer member;
    private CdKMemberEntity contact;
    private Relationship relationship;
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

    @Basic
    @Column(name = "member")
    public Integer getMember() {
        return member;
    }

    public void setMember(Integer member) {
        this.member = member;
    }

    @OneToOne
    @JoinColumn(name = "contact")
    public CdKMemberEntity getContact() {
        return contact;
    }

    public void setContact(CdKMemberEntity contact) {
        this.contact = contact;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "relationship", columnDefinition = "ENUM('ROSTER', 'BLOCK', 'ABUSE')")
    public Relationship getRelationship() {
        return relationship;
    }

    public void setRelationship(Relationship relationship) {
        this.relationship = relationship;
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

        CdKRosterEntity that = (CdKRosterEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (reference != null ? !reference.equals(that.reference) : that.reference != null) return false;
        if (member != null ? !member.equals(that.member) : that.member != null) return false;
        if (contact != null ? !contact.equals(that.contact) : that.contact != null) return false;
        if (relationship != null ? !relationship.equals(that.relationship) : that.relationship != null) return false;
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
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        result = 31 * result + (relationship != null ? relationship.hashCode() : 0);
        result = 31 * result + (made != null ? made.hashCode() : 0);
        result = 31 * result + (revised != null ? revised.hashCode() : 0);
        result = 31 * result + (purged != null ? purged.hashCode() : 0);
        return result;
    }
}

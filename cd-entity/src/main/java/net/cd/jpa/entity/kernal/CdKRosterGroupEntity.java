package net.cd.jpa.entity.kernal;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Vincent 05/12/2017.
 */
@Entity
@Table(name = "cd_kRosterGroup")
public class CdKRosterGroupEntity {
    private Integer id;
    private String reference;
    private CdKMemberEntity member;
    private String name;
    private List<CdKRosterEntity> cdKRosterEntityList;
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

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "cd_kRosterGroupContact",
            joinColumns = @JoinColumn(name = "rostergroup", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "contact", referencedColumnName = "id"))
    public List<CdKRosterEntity> getCdKRosterEntityList() {
        return cdKRosterEntityList;
    }

    public void setCdKRosterEntityList(List<CdKRosterEntity> cdKRosterEntityList) {
        this.cdKRosterEntityList = cdKRosterEntityList;
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

        CdKRosterGroupEntity that = (CdKRosterGroupEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (reference != null ? !reference.equals(that.reference) : that.reference != null) return false;
        if (member != null ? !member.equals(that.member) : that.member != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
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
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (made != null ? made.hashCode() : 0);
        result = 31 * result + (revised != null ? revised.hashCode() : 0);
        result = 31 * result + (purged != null ? purged.hashCode() : 0);
        return result;
    }
}

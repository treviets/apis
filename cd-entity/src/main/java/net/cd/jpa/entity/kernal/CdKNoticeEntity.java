package net.cd.jpa.entity.kernal;

import net.cd.jpa.entity.lookup.CdLL10NEntity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Vincent on 05/12/2017.
 */
@Entity
@Table(name = "cd_kNotice")
public class CdKNoticeEntity {

    public enum Status {
        DRAFT, PUBLISH
    }

    private Integer id;
    private String reference;
    private CdLL10NEntity title;
    private CdLL10NEntity detail;
    private String purpose;
    private Status status;
    private Timestamp expiry;
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
    @JoinColumn(name = "title")
    public CdLL10NEntity getTitle() {
        return title;
    }

    public void setTitle(CdLL10NEntity title) {
        this.title = title;
    }

    @OneToOne
    @JoinColumn(name = "detail")
    public CdLL10NEntity getDetail() {
        return detail;
    }

    public void setDetail(CdLL10NEntity detail) {
        this.detail = detail;
    }

    @Basic
    @Column(name = "purpose")
    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "ENUM('DRAFT', 'PUBLISH')")
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Basic
    @Column(name = "expiry")
    public Timestamp getExpiry() {
        return expiry;
    }

    public void setExpiry(Timestamp expiry) {
        this.expiry = expiry;
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

        CdKNoticeEntity that = (CdKNoticeEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (reference != null ? !reference.equals(that.reference) : that.reference != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (detail != null ? !detail.equals(that.detail) : that.detail != null) return false;
        if (purpose != null ? !purpose.equals(that.purpose) : that.purpose != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (expiry != null ? !expiry.equals(that.expiry) : that.expiry != null) return false;
        if (made != null ? !made.equals(that.made) : that.made != null) return false;
        if (revised != null ? !revised.equals(that.revised) : that.revised != null) return false;
        if (purged != null ? !purged.equals(that.purged) : that.purged != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (reference != null ? reference.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (detail != null ? detail.hashCode() : 0);
        result = 31 * result + (purpose != null ? purpose.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (expiry != null ? expiry.hashCode() : 0);
        result = 31 * result + (made != null ? made.hashCode() : 0);
        result = 31 * result + (revised != null ? revised.hashCode() : 0);
        result = 31 * result + (purged != null ? purged.hashCode() : 0);
        return result;
    }
}

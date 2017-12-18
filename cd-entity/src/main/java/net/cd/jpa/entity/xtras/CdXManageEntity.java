package net.cd.jpa.entity.xtras;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Vincent 05/12/2017.
 */
@Entity
@Table(name = "cd_xManage")
public class CdXManageEntity {
    private Integer id;
    private String email;
    private String hash;
    private String secret;
    private Integer suspend;
    private Integer superuser;
    private Timestamp made;
    private Timestamp revised;
    private Timestamp purged;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "hash")
    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Basic
    @Column(name = "secret")
    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Basic
    @Column(name = "suspend")
    public Integer getSuspend() {
        return suspend;
    }

    public void setSuspend(Integer suspend) {
        this.suspend = suspend;
    }

    @Basic
    @Column(name = "superuser")
    public Integer getSuperuser() {
        return superuser;
    }

    public void setSuperuser(Integer superuser) {
        this.superuser = superuser;
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

        CdXManageEntity that = (CdXManageEntity) o;

        if (id != that.id) return false;
        if (suspend != that.suspend) return false;
        if (superuser != that.superuser) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (hash != null ? !hash.equals(that.hash) : that.hash != null) return false;
        if (secret != null ? !secret.equals(that.secret) : that.secret != null) return false;
        if (made != null ? !made.equals(that.made) : that.made != null) return false;
        if (revised != null ? !revised.equals(that.revised) : that.revised != null) return false;
        if (purged != null ? !purged.equals(that.purged) : that.purged != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (hash != null ? hash.hashCode() : 0);
        result = 31 * result + (secret != null ? secret.hashCode() : 0);
        result = 31 * result + suspend;
        result = 31 * result + superuser;
        result = 31 * result + (made != null ? made.hashCode() : 0);
        result = 31 * result + (revised != null ? revised.hashCode() : 0);
        result = 31 * result + (purged != null ? purged.hashCode() : 0);
        return result;
    }
}

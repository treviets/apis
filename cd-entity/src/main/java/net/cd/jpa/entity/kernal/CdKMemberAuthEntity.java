package net.cd.jpa.entity.kernal;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Vincent on 05/12/2017.
 */
@Entity
@Table(name = "cd_kMemberAuth")
public class CdKMemberAuthEntity {

    private Integer id;
    private CdKMemberEntity member;
    private CdKAuthEntity auth;
    private Timestamp made;
    private Timestamp revised;
    private Timestamp purged;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    @JoinColumn(name = "auth")
    public CdKAuthEntity getAuth() {
        return auth;
    }

    public void setAuth(CdKAuthEntity auth) {
        this.auth = auth;
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CdKMemberAuthEntity that = (CdKMemberAuthEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) {
            return false;
        }
        if (member != null ? !member.equals(that.member) : that.member != null) {
            return false;
        }
        if (auth != null ? !auth.equals(that.auth) : that.auth != null) {
            return false;
        }
        if (made != null ? !made.equals(that.made) : that.made != null) {
            return false;
        }
        if (revised != null ? !revised.equals(that.revised) : that.revised != null) {
            return false;
        }
        if (purged != null ? !purged.equals(that.purged) : that.purged != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (member != null ? member.hashCode() : 0);
        result = 31 * result + (auth != null ? auth.hashCode() : 0);
        result = 31 * result + (made != null ? made.hashCode() : 0);
        result = 31 * result + (revised != null ? revised.hashCode() : 0);
        result = 31 * result + (purged != null ? purged.hashCode() : 0);
        return result;
    }
}

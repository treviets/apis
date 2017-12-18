package net.cd.jpa.entity.lookup;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Vinent 05/12/2017.
 */
@Entity
@Table(name = "cd_lError")
public class CdLErrorEntity {

    private Integer id;
    private CdLL10NEntity l10N;
    private Integer code;
    private Integer enable;
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

    @OneToOne
    @JoinColumn(name = "l10n")
    public CdLL10NEntity getL10N() {
        return l10N;
    }

    public void setL10N(CdLL10NEntity l10N) {
        this.l10N = l10N;
    }

    @Basic
    @Column(name = "code")
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Basic
    @Column(name = "enable")
    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
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

        CdLErrorEntity that = (CdLErrorEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (l10N != null ? !l10N.equals(that.l10N) : that.l10N != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (enable != null ? !enable.equals(that.enable) : that.enable != null) return false;
        if (made != null ? !made.equals(that.made) : that.made != null) return false;
        if (revised != null ? !revised.equals(that.revised) : that.revised != null) return false;
        if (purged != null ? !purged.equals(that.purged) : that.purged != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (l10N != null ? l10N.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (enable != null ? enable.hashCode() : 0);
        result = 31 * result + (made != null ? made.hashCode() : 0);
        result = 31 * result + (revised != null ? revised.hashCode() : 0);
        result = 31 * result + (purged != null ? purged.hashCode() : 0);
        return result;
    }
}

package net.cd.jpa.entity.xtras;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;

/**
 * Created by Vincent on 05/12/2017.
 */
@Entity
@Table(name = "cd_xKvBLOB")
public class CdXKvBLOBEntity {
    private Integer id;
    private String randition;
    private String k;
    private byte[] v;
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

    @Basic
    @Column(name = "randition")
    public String getRandition() {
        return randition;
    }

    public void setRandition(String randition) {
        this.randition = randition;
    }

    @Basic
    @Column(name = "k")
    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    @Lob
    @Column(name = "v")
    public byte[] getV() {
        return v;
    }

    public void setV(byte[] v) {
        this.v = v;
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

        CdXKvBLOBEntity that = (CdXKvBLOBEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (randition != null ? !randition.equals(that.randition) : that.randition != null) return false;
        if (k != null ? !k.equals(that.k) : that.k != null) return false;
        if (!Arrays.equals(v, that.v)) return false;
        if (enable != null ? !enable.equals(that.enable) : that.enable != null) return false;
        if (made != null ? !made.equals(that.made) : that.made != null) return false;
        if (revised != null ? !revised.equals(that.revised) : that.revised != null) return false;
        if (purged != null ? !purged.equals(that.purged) : that.purged != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (randition != null ? randition.hashCode() : 0);
        result = 31 * result + (k != null ? k.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(v);
        result = 31 * result + (enable != null ? enable.hashCode() : 0);
        result = 31 * result + (made != null ? made.hashCode() : 0);
        result = 31 * result + (revised != null ? revised.hashCode() : 0);
        result = 31 * result + (purged != null ? purged.hashCode() : 0);
        return result;
    }
}

package net.cd.jpa.entity.lookup;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Vincent on 05/12/2017.
 */
@Entity
@Table(name = "cd_lL10n")
public class CdLL10NEntity {
    private Integer id;
    private String randition;
    private String enUs;
    private String zhHk;
    private String zhTw;
    private String zhHans;
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
    @Column(name = "en_US")
    public String getEnUs() {
        return enUs;
    }

    public void setEnUs(String enUs) {
        this.enUs = enUs;
    }

    @Basic
    @Column(name = "zh_HK")
    public String getZhHk() {
        return zhHk;
    }

    public void setZhHk(String zhHk) {
        this.zhHk = zhHk;
    }

    @Basic
    @Column(name = "zh_TW")
    public String getZhTw() {
        return zhTw;
    }

    public void setZhTw(String zhTw) {
        this.zhTw = zhTw;
    }

    @Basic
    @Column(name = "zh_Hans")
    public String getZhHans() {
        return zhHans;
    }

    public void setZhHans(String zhHans) {
        this.zhHans = zhHans;
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

        CdLL10NEntity that = (CdLL10NEntity) o;

        if (id != that.id) return false;
        if (randition != null ? !randition.equals(that.randition) : that.randition != null) return false;
        if (enUs != null ? !enUs.equals(that.enUs) : that.enUs != null) return false;
        if (zhHk != null ? !zhHk.equals(that.zhHk) : that.zhHk != null) return false;
        if (zhTw != null ? !zhTw.equals(that.zhTw) : that.zhTw != null) return false;
        if (zhHans != null ? !zhHans.equals(that.zhHans) : that.zhHans != null) return false;
        if (made != null ? !made.equals(that.made) : that.made != null) return false;
        if (revised != null ? !revised.equals(that.revised) : that.revised != null) return false;
        if (purged != null ? !purged.equals(that.purged) : that.purged != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (randition != null ? randition.hashCode() : 0);
        result = 31 * result + (enUs != null ? enUs.hashCode() : 0);
        result = 31 * result + (zhHk != null ? zhHk.hashCode() : 0);
        result = 31 * result + (zhTw != null ? zhTw.hashCode() : 0);
        result = 31 * result + (zhHans != null ? zhHans.hashCode() : 0);
        result = 31 * result + (made != null ? made.hashCode() : 0);
        result = 31 * result + (revised != null ? revised.hashCode() : 0);
        result = 31 * result + (purged != null ? purged.hashCode() : 0);
        return result;
    }
}

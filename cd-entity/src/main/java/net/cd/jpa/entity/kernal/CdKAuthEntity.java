package net.cd.jpa.entity.kernal;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Tree.Yip on 25/6/2017.
 * Modify by Vincent on 23 Nov 
 */
@Entity
@Table(name = "cd_kAuth")
public class CdKAuthEntity {

    public enum Method {
        OAUTH, XMPP, RFC6238
    }

    private Integer id;
    private Integer member;
    private String account;
    private String secret;
    private Method method;
    private Integer suspend;
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
    @Column(name = "member")
    public Integer getMember() {
        return member;
    }

    public void setMember(Integer member) {
        this.member = member;
    }
    
    @Basic
    @Column(name = "account")
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Basic
    @Column(name = "secret")
    public String getSecret() {
        return secret;
    }

    public void setSecret(String rfc6238) {
        this.secret = rfc6238;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "method", columnDefinition = "ENUM('OAUTH','XMPP','RFC6238')")
    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    @Basic
    @Column(name = "`suspend`")
    public Integer getSuspend() {
        return suspend;
    }

    public void setSuspend(Integer suspend) {
        this.suspend = suspend;
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

        CdKAuthEntity that = (CdKAuthEntity) o;

        if (id != that.id) return false;
        if (account != null ? !account.equals(that.account) : that.account != null) return false;
        if (secret != null ? !secret.equals(that.secret) : that.secret != null) return false;
        if (method != null ? !method.equals(that.method) : that.method != null) return false;
        if (suspend != that.suspend) return false;
        if (made != null ? !made.equals(that.made) : that.made != null) return false;
        if (revised != null ? !revised.equals(that.revised) : that.revised != null) return false;
        if (purged != null ? !purged.equals(that.purged) : that.purged != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + (secret != null ? secret.hashCode() : 0);
        result = 31 * result + (method != null ? method.hashCode() : 0);
        result = 31 * result + suspend;
        result = 31 * result + (made != null ? made.hashCode() : 0);
        result = 31 * result + (revised != null ? revised.hashCode() : 0);
        result = 31 * result + (purged != null ? purged.hashCode() : 0);
        return result;
    }
}

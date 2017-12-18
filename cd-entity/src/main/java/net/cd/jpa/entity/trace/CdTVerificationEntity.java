package net.cd.jpa.entity.trace;

import net.cd.jpa.entity.kernal.CdKMemberEntity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Vincent 05/12/2017.
 */
@Entity
@Table(name = "cd_tVerification")
public class CdTVerificationEntity {

    public enum Channel {
        EMAIL, SMS
    }

    public enum Type {
        REG, RESET, TEMPASS
    }

    private Integer id;
    private CdKMemberEntity member;
    private String code;
    private Channel channel;
    private Type type;
    private Integer ttl;
    private Integer verified;
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
    @JoinColumn(name = "member")
    public CdKMemberEntity getMember() {
        return member;
    }

    public void setMember(CdKMemberEntity member) {
        this.member = member;
    }

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "channel", columnDefinition = "ENUM('EMAIL', 'SMS')")
    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "type", columnDefinition = "ENUM('TYPE')")
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Basic
    @Column(name = "ttl")
    public Integer getTtl() {
        return ttl;
    }

    public void setTtl(Integer ttl) {
        this.ttl = ttl;
    }

    @Basic
    @Column(name = "verified")
    public Integer getVerified() {
        return verified;
    }

    public void setVerified(Integer verified) {
        this.verified = verified;
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

        CdTVerificationEntity that = (CdTVerificationEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (member != null ? !member.equals(that.member) : that.member != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (channel != null ? !channel.equals(that.channel) : that.channel != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (ttl != null ? !ttl.equals(that.ttl) : that.ttl != null) return false;
        if (verified != null ? !verified.equals(that.verified) : that.verified != null) return false;
        if (made != null ? !made.equals(that.made) : that.made != null) return false;
        if (revised != null ? !revised.equals(that.revised) : that.revised != null) return false;
        if (purged != null ? !purged.equals(that.purged) : that.purged != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (member != null ? member.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (channel != null ? channel.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (ttl != null ? ttl.hashCode() : 0);
        result = 31 * result + (verified != null ? verified.hashCode() : 0);
        result = 31 * result + (made != null ? made.hashCode() : 0);
        result = 31 * result + (revised != null ? revised.hashCode() : 0);
        result = 31 * result + (purged != null ? purged.hashCode() : 0);
        return result;
    }
}

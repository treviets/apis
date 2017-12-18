package net.cd.jpa.entity.kernal;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Vincent 05/12/2017.
 */
@Entity
@Table(name = "cd_kChatGroupParticipate")
public class CdKChatGroupParticipateEntity {
    private Integer id;
    private CdKChatGroupEntity chatgroup;
    private CdKMemberEntity participate;
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

    @OneToOne
    @JoinColumn(name = "chatgroup")
    public CdKChatGroupEntity getChatgroup() {
        return chatgroup;
    }

    public void setChatgroup(CdKChatGroupEntity chatgroup) {
        this.chatgroup = chatgroup;
    }

    @OneToOne
    @JoinColumn(name = "participate")
    public CdKMemberEntity getParticipate() {
        return participate;
    }

    public void setParticipate(CdKMemberEntity participate) {
        this.participate = participate;
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

        CdKChatGroupParticipateEntity that = (CdKChatGroupParticipateEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (chatgroup != null ? !chatgroup.equals(that.chatgroup) : that.chatgroup != null) return false;
        if (participate != null ? !participate.equals(that.participate) : that.participate != null) return false;
        if (made != null ? !made.equals(that.made) : that.made != null) return false;
        if (revised != null ? !revised.equals(that.revised) : that.revised != null) return false;
        if (purged != null ? !purged.equals(that.purged) : that.purged != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (chatgroup != null ? chatgroup.hashCode() : 0);
        result = 31 * result + (participate != null ? participate.hashCode() : 0);
        result = 31 * result + (made != null ? made.hashCode() : 0);
        result = 31 * result + (revised != null ? revised.hashCode() : 0);
        result = 31 * result + (purged != null ? purged.hashCode() : 0);
        return result;
    }
}

package net.cd.jpa.entity.lookup;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Vincent 05/12/2017.
 */
@Entity
@Table(name = "cd_lTemplateMessage")
public class CdLTemplateMessageEntity {

    public enum EntityTypes {
        BILLING, AUTH, BILL,
    }

    public enum ChannelTypes {
        SMS, MAIL,
    }

    public enum ActionTypes {
        REGISTER, RESET, SEND
    }

    private Integer id;
    private CdLL10NEntity l10N;
    private CdLL10NEntity header;
    private EntityTypes entity;
    private ChannelTypes channel;
    private ActionTypes action;
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

    @OneToOne
    @JoinColumn(name = "header")
    public CdLL10NEntity getHeader() {
        return header;
    }

    public void setHeader(CdLL10NEntity header) {
        this.header = header;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "entity", columnDefinition = "ENUM('BILLING', 'AUTH', 'BILL')")
    public EntityTypes getEntity() {
        return entity;
    }

    public void setEntity(EntityTypes entity) {
        this.entity = entity;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "channel", columnDefinition = "ENUM('SMS', 'MAIL')")
    public ChannelTypes getChannel() {
        return channel;
    }

    public void setChannel(ChannelTypes channel) {
        this.channel = channel;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "action", columnDefinition = "ENUM('REGISTER', 'RESET', 'SEND')")
    public ActionTypes getAction() {
        return action;
    }

    public void setAction(ActionTypes action) {
        this.action = action;
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

        CdLTemplateMessageEntity that = (CdLTemplateMessageEntity) o;

        if (id != that.id) return false;
        if (l10N != null ? !l10N.equals(that.l10N) : that.l10N != null) return false;
        if (header != null ? !header.equals(that.header) : that.header != null) return false;
        if (entity != null ? !entity.equals(that.entity) : that.entity != null) return false;
        if (channel != null ? !channel.equals(that.channel) : that.channel != null) return false;
        if (action != null ? !action.equals(that.action) : that.action != null) return false;
        if (enable != that.enable) return false;
        if (made != null ? !made.equals(that.made) : that.made != null) return false;
        if (revised != null ? !revised.equals(that.revised) : that.revised != null) return false;
        if (purged != null ? !purged.equals(that.purged) : that.purged != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (l10N != null ? l10N.hashCode() : 0);
        result = 31 * result + (header != null ? header.hashCode() : 0);
        result = 31 * result + (entity != null ? entity.hashCode() : 0);
        result = 31 * result + (channel != null ? channel.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        result = 31 * result + (enable != null ? enable.hashCode() : 0);
        result = 31 * result + (made != null ? made.hashCode() : 0);
        result = 31 * result + (revised != null ? revised.hashCode() : 0);
        result = 31 * result + (purged != null ? purged.hashCode() : 0);
        return result;
    }
}

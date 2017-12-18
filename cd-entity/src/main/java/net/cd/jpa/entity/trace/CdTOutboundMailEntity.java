package net.cd.jpa.entity.trace;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Vincent on 05/12/2017.
 */
@Entity
@Table(name = "cd_tOutboundMail")
public class CdTOutboundMailEntity {

    public enum Status {
        PENDING, QUEUED, SENT, FAILURE
    }

    private Integer id; 
    private String recipient;
    private String carboncopy;
    private String blind;
    private String subject;
    private String body;
    private String response;
    private Status status;
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
    @Column(name = "recipient")
    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    @Basic
    @Column(name = "carboncopy")
    public String getCarboncopy() {
        return carboncopy;
    }

    public void setCarboncopy(String carboncopy) {
        this.carboncopy = carboncopy;
    }

    @Basic
    @Column(name = "blind")
    public String getBlind() {
        return blind;
    }

    public void setBlind(String blind) {
        this.blind = blind;
    }

    @Basic
    @Column(name = "subject")
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Basic
    @Column(name = "body")
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Basic
    @Column(name = "response")
    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "ENUM('PENDING', 'QUEUED', 'SENT', 'FAILURE')")
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

        CdTOutboundMailEntity that = (CdTOutboundMailEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (recipient != null ? !recipient.equals(that.recipient) : that.recipient != null) return false;
        if (carboncopy != null ? !carboncopy.equals(that.carboncopy) : that.carboncopy != null) return false;
        if (blind != null ? !blind.equals(that.blind) : that.blind != null) return false;
        if (subject != null ? !subject.equals(that.subject) : that.subject != null) return false;
        if (body != null ? !body.equals(that.body) : that.body != null) return false;
        if (response != null ? !response.equals(that.response) : that.response != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (made != null ? !made.equals(that.made) : that.made != null) return false;
        if (revised != null ? !revised.equals(that.revised) : that.revised != null) return false;
        if (purged != null ? !purged.equals(that.purged) : that.purged != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (recipient != null ? recipient.hashCode() : 0);
        result = 31 * result + (carboncopy != null ? carboncopy.hashCode() : 0);
        result = 31 * result + (blind != null ? blind.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (response != null ? response.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (made != null ? made.hashCode() : 0);
        result = 31 * result + (revised != null ? revised.hashCode() : 0);
        result = 31 * result + (purged != null ? purged.hashCode() : 0);
        return result;
    }
}

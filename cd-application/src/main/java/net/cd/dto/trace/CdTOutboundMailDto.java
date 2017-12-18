package net.cd.dto.trace;

import net.cd.jpa.entity.trace.CdTOutboundMailEntity;

import javax.validation.constraints.NotNull;

/**
 * Created by Vincent 01/12/2017
 */
public class CdTOutboundMailDto {

    @NotNull
    private Integer id;
    private String recipient;
    private String carboncopy;
    private String blind;
    private String subject;
    private String body;
    private String response;
    private CdTOutboundMailEntity.Status status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getCarboncopy() {
        return carboncopy;
    }

    public void setCarboncopy(String carboncopy) {
        this.carboncopy = carboncopy;
    }

    public String getBlind() {
        return blind;
    }

    public void setBlind(String blind) {
        this.blind = blind;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public CdTOutboundMailEntity.Status getStatus() {
        return status;
    }

    public void setStatus(CdTOutboundMailEntity.Status status) {
        this.status = status;
    }
}

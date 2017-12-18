package net.cd.dto.trace;

import net.cd.jpa.entity.trace.CdTOutboundSMSEntity;

import javax.validation.constraints.NotNull;

/**
 * Created by Vincent 01/12/2017
 */
public class CdTOutboundSMSDto {

    @NotNull
    private Integer id;
    private Long mobile;
    private String gateway;
    private String payload;
    private String response;
    private Integer httpstatus;
    private CdTOutboundSMSEntity.Status status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Integer getHttpstatus() {
        return httpstatus;
    }

    public void setHttpstatus(Integer httpstatus) {
        this.httpstatus = httpstatus;
    }

    public CdTOutboundSMSEntity.Status getStatus() {
        return status;
    }

    public void setStatus(CdTOutboundSMSEntity.Status status) {
        this.status = status;
    }
}

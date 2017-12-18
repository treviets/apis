package net.cd.dto.trace;

import javax.validation.constraints.NotNull;

/**
 * Created by Vincent 01/12/2017
 */
public class CdTInboundAuthDto {

    @NotNull
    private Integer id;

    private String email;

    private String ciphers;

    private String ip;

    private Integer adopt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCiphers() {
        return ciphers;
    }

    public void setCiphers(String ciphers) {
        this.ciphers = ciphers;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getAdopt() {
        return adopt;
    }

    public void setAdopt(Integer adopt) {
        this.adopt = adopt;
    }
}

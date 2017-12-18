package net.cd.dto.kernal;

import net.cd.jpa.entity.kernal.CdKAuthEntity;

import javax.validation.constraints.NotNull;

/**
 * Created by Vincent on 01/12/2017.
 */
public class CdKAuthDto {

    @NotNull
    private Integer id;
    private Integer member;
    private String account;
    private String secret;
    private CdKAuthEntity.Method method;
    private Integer suspend;
    private Integer revoke;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMember() {
        return member;
    }

    public void setMember(Integer member) {
        this.member = member;
    }
    
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public CdKAuthEntity.Method getMethod() {
        return method;
    }

    public void setMethod(CdKAuthEntity.Method method) {
        this.method = method;
    }

    public Integer getSuspend() {
        return suspend;
    }

    public void setSuspend(Integer suspend) {
        this.suspend = suspend;
    }

    public Integer getRevoke() {
        return revoke;
    }

    public void setRevoke(Integer revoke) {
        this.revoke = revoke;
    }
}

package net.cd.dto.xtras;

import javax.validation.constraints.NotNull;

/**
 * Created by Vincent 01/12/2017
 */
public class CdXManageDto {

    @NotNull
    private Integer id;

    private String email;

    private String hash;

    private String secret;

    private Integer suspend;

    private Integer superuser;

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

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Integer getSuspend() {
        return suspend;
    }

    public void setSuspend(Integer suspend) {
        this.suspend = suspend;
    }

    public Integer getSuperuser() {
        return superuser;
    }

    public void setSuperuser(Integer superuser) {
        this.superuser = superuser;
    }
}

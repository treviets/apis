package net.cd.dto.trace;

import javax.validation.constraints.NotNull;

/**
 * Created by Vincent 01/12/2017
 */
public class CdTInboundRedirectDto {

    @NotNull
    private Integer id;

    private String locale;

    private String payload;

    private Integer resolve;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public Integer getResolve() {
        return resolve;
    }

    public void setResolve(Integer resolve) {
        this.resolve = resolve;
    }
}

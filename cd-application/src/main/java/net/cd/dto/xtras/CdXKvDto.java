package net.cd.dto.xtras;

import javax.validation.constraints.NotNull;

/**
 * Created by Vincent 01/12/2017
 */
public class CdXKvDto {

    @NotNull
    private Integer id;
    private String k;
    private String v;

    public CdXKvDto() {
    }

    public CdXKvDto(Integer id, String k, String v) {
        this.id = id;
        this.k = k;
        this.v = v;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }
}

package net.cd.dto.xtras;

/**
 * Created by Vincent 01/12/2017
 */
public class CdXKvBLOBDto {

    private Integer id;
    private String randition;
    private String k;
    private byte[] v;
    private Integer enable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRandition() {
        return randition;
    }

    public void setRandition(String randition) {
        this.randition = randition;
    }

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public byte[] getV() {
        return v;
    }

    public void setV(byte[] v) {
        this.v = v;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }
}

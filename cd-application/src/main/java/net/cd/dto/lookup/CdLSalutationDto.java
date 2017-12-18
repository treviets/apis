package net.cd.dto.lookup;

import javax.validation.constraints.NotNull;

/**
 * Created by Vincent 01/12/2017
 */
public class CdLSalutationDto {

    @NotNull
    private Integer id;
    private CdLL10NDto l10N;
    private Integer enable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CdLL10NDto getL10N() {
        return l10N;
    }

    public void setL10N(CdLL10NDto l10N) {
        this.l10N = l10N;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }
}

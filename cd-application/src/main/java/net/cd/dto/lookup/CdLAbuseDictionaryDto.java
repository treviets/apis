package net.cd.dto.lookup;

/**
 * Created by Vincent 01/12/2017
 */
public class CdLAbuseDictionaryDto {
    private Integer id;
    private CdLL10NDto l10N;

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
}

package net.cd.dto.kernal;

import net.cd.dto.lookup.CdLL10NDto;
import net.cd.jpa.entity.kernal.CdKNoticeEntity;

/**
 * Created by Vincent 01/12/2017
 */
public class CdKNoticeDto {
    private Integer id;
    private String reference;
    private CdLL10NDto title;
    private CdLL10NDto detail;
    private String purpose;
    private CdKNoticeEntity.Status status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public CdLL10NDto getTitle() {
        return title;
    }

    public void setTitle(CdLL10NDto title) {
        this.title = title;
    }

    public CdLL10NDto getDetail() {
        return detail;
    }

    public void setDetail(CdLL10NDto detail) {
        this.detail = detail;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public CdKNoticeEntity.Status getStatus() {
        return status;
    }

    public void setStatus(CdKNoticeEntity.Status status) {
        this.status = status;
    }
}

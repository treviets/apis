package net.cd.dto.xtras;

import net.cd.jpa.entity.xtras.CdXExceptionEntity;
import org.modelmapper.ModelMapper;

/**
 * Created by Vincent 01/12/2017
 */
public class CdXExceptionDto extends CdXExceptionTinyDto {

    private Integer id;
    private String reference;
    private CdXExceptionEntity.Severity severity;
    private String stacktrace;
    private String endpoint;
    private String header;
    private String query;
    private String dto;
    private String remote;

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

    public CdXExceptionEntity.Severity getSeverity() {
        return severity;
    }

    public void setSeverity(CdXExceptionEntity.Severity severity) {
        this.severity = severity;
    }

    public String getStacktrace() {
        return stacktrace;
    }

    public void setStacktrace(String stacktrace) {
        this.stacktrace = stacktrace;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getDto() {
        return dto;
    }

    public void setDto(String dto) {
        this.dto = dto;
    }

    public String getRemote() {
        return remote;
    }

    public void setRemote(String remote) {
        this.remote = remote;
    }

    public CdXExceptionTinyDto getTiny() {
        CdXExceptionTinyDto tiny = new CdXExceptionTinyDto();
        new ModelMapper().map(this, tiny);
        return tiny;
    }
}

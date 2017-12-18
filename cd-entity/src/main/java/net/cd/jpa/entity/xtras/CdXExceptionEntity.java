package net.cd.jpa.entity.xtras;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Vincent on 05/12/2017.
 */
@Entity
@Table(name = "cd_xException")
public class CdXExceptionEntity {

    public enum Severity {
        MINOR, MAJOR;
    }

    private Integer id;
    private String reference;
    private Severity severity;
    private String code;
    private String message;
    private String localized;
    private String stacktrace;
    private String endpoint;
    private String header;
    private String query;
    private String dto;
    private String remote;
    private Timestamp made;
    private Timestamp revised;
    private Timestamp purged;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "reference")
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "severity", columnDefinition = "ENUM('MINOR', 'MAJOR')")
    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "localized")
    public String getLocalized() {
        return localized;
    }

    public void setLocalized(String localized) {
        this.localized = localized;
    }

    @Basic
    @Column(name = "stacktrace")
    public String getStacktrace() {
        return stacktrace;
    }

    public void setStacktrace(String stacktrace) {
        this.stacktrace = stacktrace;
    }

    @Basic
    @Column(name = "endpoint")
    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    @Basic
    @Column(name = "header")
    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    @Basic
    @Column(name = "query")
    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Basic
    @Column(name = "dto")
    public String getDto() {
        return dto;
    }

    public void setDto(String dto) {
        this.dto = dto;
    }

    @Basic
    @Column(name = "remote")
    public String getRemote() {
        return remote;
    }

    public void setRemote(String remote) {
        this.remote = remote;
    }

    @Basic
    @Column(name = "made")
    public Timestamp getMade() {
        return made;
    }

    public void setMade(Timestamp made) {
        this.made = made;
    }

    @Basic
    @Column(name = "revised")
    public Timestamp getRevised() {
        return revised;
    }

    public void setRevised(Timestamp revised) {
        this.revised = revised;
    }

    @Basic
    @Column(name = "purged")
    public Timestamp getPurged() {
        return purged;
    }

    public void setPurged(Timestamp purged) {
        this.purged = purged;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CdXExceptionEntity that = (CdXExceptionEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (reference != null ? !reference.equals(that.reference) : that.reference != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        if (localized != null ? !localized.equals(that.localized) : that.localized != null) return false;
        if (stacktrace != null ? !stacktrace.equals(that.stacktrace) : that.stacktrace != null) return false;
        if (endpoint != null ? !endpoint.equals(that.endpoint) : that.endpoint != null) return false;
        if (header != null ? !header.equals(that.header) : that.header != null) return false;
        if (query != null ? !query.equals(that.query) : that.query != null) return false;
        if (dto != null ? !dto.equals(that.dto) : that.dto != null) return false;
        if (remote != null ? !remote.equals(that.remote) : that.remote != null) return false;
        if (made != null ? !made.equals(that.made) : that.made != null) return false;
        if (revised != null ? !revised.equals(that.revised) : that.revised != null) return false;
        if (purged != null ? !purged.equals(that.purged) : that.purged != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (reference != null ? reference.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (localized != null ? localized.hashCode() : 0);
        result = 31 * result + (stacktrace != null ? stacktrace.hashCode() : 0);
        result = 31 * result + (endpoint != null ? endpoint.hashCode() : 0);
        result = 31 * result + (header != null ? header.hashCode() : 0);
        result = 31 * result + (query != null ? query.hashCode() : 0);
        result = 31 * result + (dto != null ? dto.hashCode() : 0);
        result = 31 * result + (remote != null ? remote.hashCode() : 0);
        result = 31 * result + (made != null ? made.hashCode() : 0);
        result = 31 * result + (revised != null ? revised.hashCode() : 0);
        result = 31 * result + (purged != null ? purged.hashCode() : 0);
        return result;
    }
}

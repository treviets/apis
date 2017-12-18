package net.cd.dto.xtras;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vincent 01/12/2017
 */
public class CdXExceptionTinyDto {

    private Integer id;
    private Integer code;
    private String message;
    private String localized;
    private String reference;
    private List<String> hints;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLocalized() {
        return localized;
    }

    public void setLocalized(String localized) {
        this.localized = localized;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public List<String> getHints() {
        return hints;
    }

    public CdXExceptionTinyDto setHints(List<String> hints) {
        this.hints = hints;
        return this;
    }

    public CdXExceptionTinyDto setHint(String hint) {
        if (this.hints == null) {
            this.hints = new ArrayList<String>();
        }
        this.hints.add(hint);
        return this;
    }
}

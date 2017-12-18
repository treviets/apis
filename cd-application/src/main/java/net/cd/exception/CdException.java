package net.cd.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vincent 01/12/2017
 */
public class CdException extends RuntimeException {

    private static final long serialVersionUID = -7440479244526424143L;
    private CdErrors error;
    private Integer code;
    private List<Object> dto;
    private List<String> hints;

    public CdException(CdErrors error) {
        super(error.name());
        this.error = error;
        this.code = error.getCode();
    }

    public CdErrors getError() {
        return error;
    }

    public void setError(CdErrors error) {
        this.error = error;
    }

    public Integer getCode() {
        return code;
    }

    public CdException setCode(Integer code) {
        this.code = code;
        return this;
    }

    public List<Object> getDto() {
        return dto;
    }

    public CdException setDto(Object dto) {
        if (this.dto == null) {
            this.dto = new ArrayList<Object>();
        }
        this.dto.add(dto);
        return this;
    }

    public List<String> getHints() {
        return hints;
    }

    public CdException setHint(String hint) {
        if (this.hints == null) {
            this.hints = new ArrayList<String>();
        }
        this.hints.add(hint);
        return this;
    }
}

package net.cd.common.util;

import com.fasterxml.jackson.annotation.JsonInclude;

import net.cd.common.util.constant.StatusError;

public class Result {

    private int status;
    private String description;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String errorCode;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Object data;

    public Result() {
        super();
    }

    public Result(StatusError error) {
        this.status = StatusUtil.FAIL_STATUS;
        this.errorCode = error.getErrorCode();
        this.description = error.getDescription();
    }

    public Result(int status, String desscription) {
        super();
        this.status = status;
        this.description = desscription;
    }

    public Result(int status, String desscription, Object data) {
        super();
        this.status = status;
        this.description = desscription;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}

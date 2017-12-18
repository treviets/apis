package net.cd.exception;

import net.cd.dto.xtras.CdXExceptionDto;
import net.cd.dto.xtras.CdXExceptionTinyDto;
import net.cd.jpa.entity.xtras.CdXExceptionEntity;
import net.cd.service.xtras.CdXExceptionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Tree.Yip on 25/6/2017.
 */
@ControllerAdvice
public class CdGlobalDefaultExceptionHandler {

    @Autowired
    CdXExceptionService cdXExceptionService;

    @Autowired
    @Value("#{cdExceptionDatabase}")
    private Boolean cdExceptionDatabase;

    @Autowired
    @Value("#{cdException2Frontent}")
    private Boolean cdException2Frontent;

    @ExceptionHandler(CdException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    CdXExceptionTinyDto handleException(HttpServletRequest request, CdException ex) {
        ex.printStackTrace();
        CdXExceptionDto response = new CdXExceptionDto();
        response.setSeverity(CdXExceptionEntity.Severity.MINOR);
        response.setCode(ex.getCode() != null ? ex.getCode() : CdErrors.CD_INTERNAL_SERVER_ERROR.getCode());
        response.setMessage(ex.getMessage());
        response.setLocalized(ex.getLocalizedMessage());
        response.setStacktrace(ExceptionUtils.getStackTrace(ex));
        response.setEndpoint(request.getServletPath());
        response.setQuery(request.getQueryString());
        response.setRemote((request.getHeader("X-FORWARDED-FOR") != null && request.getHeader("X-FORWARDED-FOR").length() > 0) ? request.getHeader("X-FORWARDED-FOR") : request.getRemoteAddr());
        response.setHints(ex.getHints());

        try {
            response.setDto(new ObjectMapper().writeValueAsString(ex.getDto()));
            response = cdXExceptionService.save(response);
            response = cdXExceptionService.findOne(response.getId());
        } catch (Exception ignore) {}

        if (cdException2Frontent) throw ex;
            return response.getTiny();
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public @ResponseBody
    CdXExceptionTinyDto handleException(HttpServletRequest request, AccessDeniedException ex) {
        ex.printStackTrace();
        CdXExceptionDto response = new CdXExceptionDto();
        response.setSeverity(CdXExceptionEntity.Severity.MAJOR);
        response.setCode(CdErrors.CD_ACCESS_IS_DENIED.getCode());
        response.setMessage(CdErrors.CD_ACCESS_IS_DENIED.name());
        response.setLocalized(CdErrors.CD_ACCESS_IS_DENIED.name());
        response.setStacktrace(ExceptionUtils.getStackTrace(ex));
        response.setEndpoint(request.getServletPath());
        response.setQuery(request.getQueryString());
        response.setRemote((request.getHeader("X-FORWARDED-FOR") != null && request.getHeader("X-FORWARDED-FOR").length() > 0) ? request.getHeader("X-FORWARDED-FOR") : request.getRemoteAddr());

        if (cdExceptionDatabase) {
            try {
                response = cdXExceptionService.save(response);
                response = cdXExceptionService.findOne(response.getId());
            } catch (Exception ignore) {}
        }

        return response.getTiny();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody
    CdXExceptionTinyDto handleException(HttpServletRequest request, Exception ex) {
        ex.printStackTrace();
        CdXExceptionDto response = new CdXExceptionDto();
        response.setSeverity(CdXExceptionEntity.Severity.MAJOR);
        response.setCode(CdErrors.CD_INTERNAL_SERVER_ERROR.getCode());
        response.setMessage(ex.getMessage());
        response.setLocalized(ex.getLocalizedMessage());
        response.setStacktrace(ExceptionUtils.getStackTrace(ex));
        response.setEndpoint(request.getServletPath());
        response.setQuery(request.getQueryString());
        response.setRemote((request.getHeader("X-FORWARDED-FOR") != null && request.getHeader("X-FORWARDED-FOR").length() > 0) ? request.getHeader("X-FORWARDED-FOR") : request.getRemoteAddr());

        if (cdExceptionDatabase) {
            try {
                response = cdXExceptionService.save(response);
                response = cdXExceptionService.findOne(response.getId());
            } catch (Exception ignore) {}
        }

        CdException vex = new CdException(CdErrors.CD_INTERNAL_SERVER_ERROR);
        if (cdException2Frontent) throw vex;
        return response.getTiny();
    }
}

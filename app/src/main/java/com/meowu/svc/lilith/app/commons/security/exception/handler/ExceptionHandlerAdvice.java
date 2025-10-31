package com.meowu.svc.lilith.app.commons.security.exception.handler;

import com.meowu.starter.web.security.exception.BusinessException;
import com.meowu.starter.web.security.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice{

    @ExceptionHandler(value = {
        Exception.class,
        RuntimeException.class,
        IllegalArgumentException.class
    })
    public Response<?> exception(Exception ex){
        // log
        log.error(ex.getMessage(), ex);
        // return
        return Response.fail(ex.getLocalizedMessage());
    }

    @ExceptionHandler(value = BusinessException.class)
    public Response<?> businessException(BusinessException ex){
        try{
            return Response.fail("");
        }catch(Exception e){
            // log for other exception
            log.error(e.getMessage(), e);
            // return default response
            return Response.fail("");
        }
    }
}

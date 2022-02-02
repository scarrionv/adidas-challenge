package com.scarrionv.publicservice.exceptions;

import com.scarrionv.publicservice.dtos.ErrorDto;
import com.scarrionv.publicservice.utils.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class SubscriptionsResponseEntityExceptionHandler
  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { SubscriptionNotFoundException.class, UnexpectedException.class })
    protected ResponseEntity<Object> handleInternalException(RuntimeException ex, WebRequest request) {
        log.error("handleInternalException -> " + ex.getMessage());
        log.debug(ex.toString());
        return handleExceptionInternal(ex, Mapper.map(ex, ErrorDto.class),
          new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleUnexpectedRuntimeException(RuntimeException ex, WebRequest request) {
        log.error("handleUnexpectedRuntimeException -> " + ex.getMessage());
        log.debug(ex.toString());
        ErrorDto errorDto = buildUnexpectedErrorDto();
        return handleExceptionInternal(ex, errorDto,
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Object> handleApiException(RuntimeException ex, WebRequest request) {
        log.error("handleApiException -> " + ex.toString());
        log.debug(ex.toString());
        ErrorDto errorDto = ((ApiException) ex).getErrorDto();
        log.error(errorDto.toString());
        return handleExceptionInternal(ex, errorDto,
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    private ErrorDto buildUnexpectedErrorDto() {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorDto.setType("UnexpectedInternalServerError");
        errorDto.setMessage("The server has encountered a situation it does not know how to handle");
        return errorDto;
    }

}

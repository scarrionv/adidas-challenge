package com.scarrionv.subscriptionservice.exceptions;


import com.scarrionv.subscriptionservice.dtos.ErrorDto;
import com.scarrionv.subscriptionservice.utils.Mapper;
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

    @ExceptionHandler(value = { SubscriptionNotFoundException.class })
    protected ResponseEntity<Object> handleNotFound(RuntimeException ex, WebRequest request) {
        log.error("handleNotFound -> " + ex.getMessage());
        log.debug(ex.toString());
        return handleExceptionInternal(ex, Mapper.map(ex, ErrorDto.class),
          new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleUnexpectedRuntimeException(RuntimeException ex, WebRequest request) {
        log.error("handleUnexpectedRuntimeException -> " + ex.getMessage());
        log.info(ex.toString());
        ErrorDto errorDto = buildUnexpectedErrorDto();
        return handleExceptionInternal(ex, errorDto,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    private ErrorDto buildUnexpectedErrorDto() {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorDto.setType("UnexpectedInternalServerError");
        errorDto.setMessage("The server has encountered a situation it does not know how to handle");
        return errorDto;
    }

}

package com.scarrionv.publicservice.clients;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.scarrionv.publicservice.dtos.ErrorDto;
import com.scarrionv.publicservice.exceptions.ApiException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Slf4j
public class SubscriptionsClientErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        ErrorDto errorDto = mapErrorDtoFromResponse(response);
        return new ApiException(errorDto);
    }

    private ErrorDto mapErrorDtoFromResponse(Response response) {
        ObjectMapper mapper = new ObjectMapper();
        ErrorDto errorDto = new ErrorDto();
        String json = null;
        try {
            InputStream inputStream = response.body().asInputStream();
            json = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            errorDto = mapper.readValue(json, ErrorDto.class);
        } catch (JsonParseException | UnrecognizedPropertyException ex ) {
            log.debug(ex.getMessage());
            errorDto.setMessage(json);
            errorDto.setType("ApiException");
            errorDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        catch (Exception e) {
            e.printStackTrace();
            errorDto.setMessage(e.getMessage());
            errorDto.setType("UnexpectedException");
            errorDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return errorDto;
    }
}

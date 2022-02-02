package com.scarrionv.publicservice.exceptions;

import com.scarrionv.publicservice.dtos.ErrorDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ApiException  extends RuntimeException {
    private final ErrorDto errorDto;

}

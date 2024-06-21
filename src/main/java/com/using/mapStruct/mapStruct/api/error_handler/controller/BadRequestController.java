package com.using.mapStruct.mapStruct.api.error_handler.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.using.mapStruct.mapStruct.api.error_handler.response.BaseErrorResponse;
import com.using.mapStruct.mapStruct.api.error_handler.response.ErrorResponse;
import com.using.mapStruct.mapStruct.api.error_handler.response.ErrorsResponse;
import com.using.mapStruct.mapStruct.utils.exceptions.BadRequestException;

@RestControllerAdvice
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseErrorResponse handleBadRequest(MethodArgumentNotValidException exception){
        List<Map<String, String>> errors = new ArrayList<>();
        Map<String, String> error = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(e ->{
            error.put("error", e.getDefaultMessage());
            error.put("field", e.getField());
            errors.add(error);            
        });
        return ErrorResponse.builder()
        .code(HttpStatus.BAD_REQUEST.value())
        .status(HttpStatus.BAD_REQUEST.name())
        .error(errors)
        .build();
    }

    @ExceptionHandler(BadRequestException.class)
    public BaseErrorResponse handleErrors(BadRequestException exception) {

        List<Map<String, String>> errors = new ArrayList<>();

        Map<String, String> error = new HashMap<>();

        error.put("Error", exception.getMessage());
        errors.add(error);
        return ErrorsResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.name())
                .message(errors)
                .build();
    }
}

package com.agora.clienteservice.exceptionhandlers;

import com.agora.clienteservice.errors.ErrorEdad;
import com.agora.clienteservice.errors.RequestException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.beans.PropertyEditor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ValidationExceptionConfig extends Exception {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> validacionArgumentoInvalido(MethodArgumentNotValidException e){
            Map<String,String> mapError = new HashMap<>();
           e.getBindingResult().getFieldErrors().forEach(error -> { mapError.put(error.getField(), error.getDefaultMessage()); });

        return mapError;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RequestException.class)
    public ResponseEntity<ErrorEdad> errorEdadException(RequestException e){
        ErrorEdad error = ErrorEdad.builder().message(e.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
   @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = InvalidFormatException.class)
    public Map<String, String> validarFechaFormato(InvalidFormatException ex){
        Map<String,String> mapError = new HashMap<>();
        mapError.put(ex.getPathReference(),ex.getOriginalMessage());

        return mapError;
    }
}

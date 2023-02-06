package com.agora.clienteservice.exceptionhandlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.format.DateTimeParseException;
import java.util.HashMap;
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
    @ExceptionHandler(value = DateTimeParseException.class)
    public Map<String, String> validarFechaFormato(DateTimeParseException ex){
        Map<String,String> mapError = new HashMap<>();
        mapError.put("FechaNacimiento:",ex.getParsedString() + " no es una fecha valida. (Formato: DD-MM-YYYY)");

        return mapError;
    }
}

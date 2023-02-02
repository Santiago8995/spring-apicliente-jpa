package com.agora.clienteservice.errors;

import lombok.Data;

@Data
public class RequestException extends RuntimeException {
    private String code;

    public RequestException(String message){
        super(message);
        this.code = code;
    }
}

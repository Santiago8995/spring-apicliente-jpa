package com.agora.clienteservice.customexceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RequestException extends RuntimeException {

    public RequestException(){
        super();
    }
}
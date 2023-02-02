package com.agora.clienteservice.errors;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.repository.query.Param;

import javax.websocket.server.PathParam;

@Builder
@Data
public class ErrorEdad {
    @JsonProperty("fechaDeNacimiento/edad")
    private String message;
}

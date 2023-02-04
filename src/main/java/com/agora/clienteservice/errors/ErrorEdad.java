package com.agora.clienteservice.errors;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class ErrorEdad {
    @JsonProperty("fechaDeNacimiento/edad")
    private String message;
}

package com.agora.clienteservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO implements Serializable {

    private Long id;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private Integer edad;
    private Integer vidaRestanteAprox;



}

package com.agora.clienteservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Component
public class ClienteDTO implements Serializable {

    private Long id;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private Integer edad;
    private Integer vidaEstimada;


    public void setVidaRestanteAprox(int i) {
       this.vidaEstimada = i;
    }
}

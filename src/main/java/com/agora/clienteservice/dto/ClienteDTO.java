package com.agora.clienteservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;



@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ClienteDTO implements Serializable {

    private Long id;
    private String nombre;
    private String apellido;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate fechaNacimiento;
    private Integer edad = null;
    private Integer vidaEstimada;


    public void setVidaRestanteAprox(int i) {
       this.vidaEstimada = i;
    }


}

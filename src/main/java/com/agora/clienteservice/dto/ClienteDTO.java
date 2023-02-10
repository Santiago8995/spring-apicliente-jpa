package com.agora.clienteservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ClienteDTO implements Serializable {

    private Long id;
    @ApiModelProperty(position = 0)
    @NotBlank(message="Nombre no puede estar vacio")
    @Size(max=15, message = "Nombre max caracteres: 15")
    @Pattern(regexp="^[A-Z](?=.{1,19}$)[A-Za-z]*(?:\\h+[A-Z][A-Za-z]*)*$", message = "Formato del nombre, incorrecto (No admite espacios, caracteres numericos o especiales)")
    private String nombre;
    @ApiModelProperty(position = 1)
    @NotBlank(message="Apellido no puede estar vacio")
    @Size(max=15, message = "Nombre max caracteres: 15")
    @Pattern(regexp="^[A-Z](?=.{1,19}$)[A-Za-z]*(?:\\h+[A-Z][A-Za-z]*)*$", message = "Formato del apellido, incorrecto (No admite espacios, caracteres numericos o especiales)")
    private String apellido;
    @ApiModelProperty(position = 2)
    @Past(message = "La fecha no puede ser posterior a la actual")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate fechaNacimiento;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer edad;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer vidaEstimada;

    public ClienteDTO(String nombre, String apellido, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setVidaRestanteAprox(int i) {
       this.vidaEstimada = i;
    }


}

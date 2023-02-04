package com.agora.clienteservice.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Builder
@Entity
@Table(name = "clientes")
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {


    @ApiModelProperty(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @ApiModelProperty(position = 0)
    @NotBlank(message="Nombre no puede estar vacio")
    @Size(max=15, message = "Nombre max caracteres: 15")
    private String nombre;

    @ApiModelProperty(position = 1)
    @NotBlank(message="Apellido no puede estar vacio")
    @Size(max=15, message = "Nombre max caracteres: 15")
    private String apellido;

    @ApiModelProperty(position = 2)
    @NotNull(message = "Edad no puede estar vacio")
    @Max(value=99, message = "Edad no puede ser mayor a 99")
    @Min(value=18, message = "Edad no puede ser menor a 18")
    private Integer edad;

    @ApiModelProperty(position = 3)
    @Past(message = "La fecha no puede ser posterior a la actual")
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private LocalDate fechaNacimiento;

    @ApiModelProperty(hidden = true)
    private Integer vidaEstimada;



    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setVidaEstimada(Integer vidaEstimada) {
        this.vidaEstimada = vidaEstimada;
    }
}

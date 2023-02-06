package com.agora.clienteservice.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Builder
@Entity
@Table(name = "clientes")
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

   final String regexNombre = "^[^-'](?=(?![A-Z]?[A-Z]))(?=(?![a-z]+[A-Z]))(?=(?!.*[A-Z][A-Z]))(?=(?!.*[-'][-'.]))(?=(?!.*[.][-'.]))[A-Za-z-'.]{2,}$";

    @ApiModelProperty(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @ApiModelProperty(position = 0)
    @NotBlank(message="Nombre no puede estar vacio")
    @Size(max=15, message = "Nombre max caracteres: 15")
    @Pattern(regexp=regexNombre, message = "Formato del nombre, incorrecto")
    private String nombre;

    @ApiModelProperty(position = 1)
    @NotBlank(message="Apellido no puede estar vacio")
    @Size(max=15, message = "Nombre max caracteres: 15")
    @Pattern(regexp=regexNombre, message = "Formato del apellido, incorrecto")
    private String apellido;

    @ApiModelProperty(position = 2)
    @Past(message = "La fecha no puede ser posterior a la actual")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaNacimiento;


    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

}

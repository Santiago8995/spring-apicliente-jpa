package com.agora.clienteservice.utils;

import com.agora.clienteservice.models.Cliente;
import com.agora.clienteservice.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;


public class Validaciones {

    @Autowired
    static
    CalculosAuxiliares calcAux;

    @Autowired
    ClienteRepository clienteRepository;


    public static Boolean validarEdad(LocalDate fecha, Integer edad){
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fecha, fechaActual);

        Integer edadAux = periodo.getYears();

      return edadAux.equals(edad);

    }


}

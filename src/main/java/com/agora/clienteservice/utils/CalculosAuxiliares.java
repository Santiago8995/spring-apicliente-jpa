package com.agora.clienteservice.utils;

import com.sun.istack.NotNull;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class CalculosAuxiliares {

    public static double getPromedio(@NotNull List<Integer> list) {
        return list.stream().mapToInt(a -> a).average().orElse(0);
    }

    public static double getDesvEstandar(@NotNull List<Integer> numArray)

    {
        double sum = 0.0, desvEstandar = 0.0;

        int length = numArray.size();

        for (double num : numArray) {

            sum += num;

        }

        double mean = sum / length;

        for (double num : numArray) {

            desvEstandar += Math.pow(num - mean, 2);

        }

        return Math.sqrt(desvEstandar / length);

    }

    public static Integer getEdadPorFecha(LocalDate fecha){
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fecha, fechaActual);
        return periodo.getYears();

    }


}

package com.agora.clienteservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class KpiCliente {

    Double promedioEdades = null;
    Double desviacionEstandar = null;

}

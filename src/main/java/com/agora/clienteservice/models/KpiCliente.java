package com.agora.clienteservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class KpiCliente {

    Double promedioEdades = null;
    Double desviacionEstandar = null;

}

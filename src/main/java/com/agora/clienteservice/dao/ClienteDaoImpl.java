package com.agora.clienteservice.dao;

import com.agora.clienteservice.models.Cliente;
import com.agora.clienteservice.models.KpiCliente;
import com.agora.clienteservice.repositories.ClienteRepository;
import com.agora.clienteservice.utils.CalculosAuxiliares;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class ClienteDaoImpl implements ClienteDAO {

    @Autowired
    ClienteRepository clienteRepository;


    public ArrayList<Cliente> findAll(){
        return (ArrayList<Cliente>) clienteRepository.findAll();
    }

    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public KpiCliente getKpiCliente(){
        List<Integer> edadesList = ((ArrayList<Cliente>) clienteRepository.findAll()).stream().map(Cliente::getEdad).collect(Collectors.toList());
        Double edadPromedio = CalculosAuxiliares.getPromedio(edadesList);
        Double desvEstandarEdad = CalculosAuxiliares.getDesvEstandar(edadesList);

        return new KpiCliente(edadPromedio,desvEstandarEdad);
    }


}

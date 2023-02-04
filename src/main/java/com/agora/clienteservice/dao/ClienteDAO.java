package com.agora.clienteservice.dao;

import com.agora.clienteservice.models.Cliente;
import com.agora.clienteservice.models.KpiCliente;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface ClienteDAO {

    public ArrayList<Cliente> findAll();

    public Cliente save(Cliente cliente);

    public KpiCliente getKpiCliente();


}

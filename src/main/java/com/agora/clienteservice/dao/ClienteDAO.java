package com.agora.clienteservice.dao;

import com.agora.clienteservice.models.Cliente;
import com.agora.clienteservice.models.KpiCliente;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.annotation.ManagedBean;
import java.util.ArrayList;
import java.util.Optional;

@Component
public interface ClienteDAO {

    public ArrayList<Cliente> findAll();

    public Cliente save(Cliente cliente);

    public ArrayList<Integer> getAllAge();



}

package com.agora.clienteservice.services;

import com.agora.clienteservice.dao.ClienteDAO;
import com.agora.clienteservice.errors.RequestException;
import com.agora.clienteservice.models.Cliente;
import com.agora.clienteservice.models.KpiCliente;
import com.agora.clienteservice.utils.Validaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClienteService {

    @Autowired
    ClienteDAO clienteDAO;

    Integer promedioVida = 75;


    public ArrayList<Cliente> listarClientes() {
        ArrayList<Cliente> listaClientes = clienteDAO.findAll();
        listaClientes.forEach(c->c.setVidaEstimada(promedioVida - c.getEdad()));
        return listaClientes;
    }


    public Cliente crearCliente(Cliente cliente) {
        if (!Validaciones.validarEdad(cliente.getFechaNacimiento(),cliente.getEdad())) {
            throw new RequestException("La edad ingresada no coincide con la fecha de nacimiento");
        }
        cliente.setVidaEstimada(promedioVida - cliente.getEdad());

        return clienteDAO.save(cliente);
    }

    public KpiCliente kpiCliente() {
        return clienteDAO.getKpiCliente();
    }

}

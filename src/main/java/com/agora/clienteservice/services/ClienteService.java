package com.agora.clienteservice.services;

import com.agora.clienteservice.dao.ClienteDAO;
import com.agora.clienteservice.errors.RequestException;
import com.agora.clienteservice.models.Cliente;
import com.agora.clienteservice.models.KpiCliente;
import com.agora.clienteservice.repositories.ClienteRepository;
import com.agora.clienteservice.utils.CalculosAuxiliares;
import com.agora.clienteservice.utils.Validaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
@Service
public class ClienteService {

    @Autowired
    ClienteDAO clienteDAO;
    CalculosAuxiliares calculoAux;
    Validaciones validacion;

    public ArrayList<Cliente> obtenerClientes() {
        return clienteDAO.findAll();
    }


    public Cliente crearCliente(Cliente cliente) {
        if (!validacion.validarEdad(cliente.getFechaNacimiento(),cliente.getEdad())) {
            throw new RequestException("La edad ingresada no coincide con la fecha de nacimiento");
        }

        return clienteDAO.save(cliente);
    }

    public KpiCliente kpiCliente() {
        ArrayList<Integer> listaEdad = clienteDAO.getAllAge();

        Double edadPromedio = calculoAux.getPromedio(listaEdad);
        Double desvEstandarEdad = calculoAux.getDesvEstandar(listaEdad);

        return new KpiCliente(edadPromedio,desvEstandarEdad);
    }

}

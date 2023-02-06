package com.agora.clienteservice.services;

import com.agora.clienteservice.dao.ClienteDAO;
import com.agora.clienteservice.dto.ClienteDTO;
import com.agora.clienteservice.models.Cliente;
import com.agora.clienteservice.models.KpiCliente;
import com.agora.clienteservice.utils.CalculosAuxiliares;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClienteService {

    @Autowired
    ClienteDAO clienteDAO;

    Integer promedioVida = 75;


    public ArrayList<ClienteDTO> listarClientes() {

        ArrayList<Cliente> listaClientes = clienteDAO.findAll();
        ArrayList<ClienteDTO>lclientesDTO = new ArrayList<>();

        for (Cliente cliente: listaClientes) {
            ClienteDTO.ClienteDTOBuilder builder = ClienteDTO.builder()
                    .id(cliente.getId())
                    .nombre(cliente.getNombre())
                    .apellido(cliente.getApellido())
                    .fechaNacimiento(cliente.getFechaNacimiento())
                    .edad(CalculosAuxiliares.getEdadPorFecha(cliente.getFechaNacimiento()));
            ClienteDTO clienteDTO = builder.build();
            clienteDTO.setVidaRestanteAprox(promedioVida - clienteDTO.getEdad());

            lclientesDTO.add(clienteDTO);
        }
        return lclientesDTO;
    }


    public Cliente crearCliente(Cliente cliente) {

        return clienteDAO.save(cliente);
    }

    public KpiCliente kpiCliente() {
        return clienteDAO.getKpiCliente();
    }

}

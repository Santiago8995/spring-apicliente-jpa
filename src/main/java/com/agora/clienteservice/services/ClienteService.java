package com.agora.clienteservice.services;

import com.agora.clienteservice.converter.ClienteConverter;
import com.agora.clienteservice.customexceptions.RequestException;
import com.agora.clienteservice.dto.ClienteDTO;
import com.agora.clienteservice.models.Cliente;
import com.agora.clienteservice.models.KpiCliente;
import com.agora.clienteservice.repositories.ClienteRepository;
import com.agora.clienteservice.utils.CalculosAuxiliares;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    ClienteConverter clienteConverter;
    @Autowired
    ModelMapper modelMapper;

    Integer promedioVida = 72;

    public ArrayList<ClienteDTO> listarClientes() {

        ArrayList<ClienteDTO>lClientesDTO = new ArrayList<>();

        for (Cliente cliente: clienteRepository.findAll()) {
            ClienteDTO.ClienteDTOBuilder builder = ClienteDTO.builder()
                    .id(cliente.getId())
                    .nombre(cliente.getNombre())
                    .apellido(cliente.getApellido())
                    .fechaNacimiento(cliente.getFechaNacimiento())
                    .edad(CalculosAuxiliares.getEdadPorFecha(cliente.getFechaNacimiento()));
            ClienteDTO clienteDTO = builder.build();
            clienteDTO.setVidaRestanteAprox(promedioVida - clienteDTO.getEdad());

            lClientesDTO.add(clienteDTO);
        }
        return lClientesDTO;
    }


    public ClienteDTO crearCliente(ClienteDTO clienteDTO) {

        if ((clienteDTO.getFechaNacimiento().getYear())> LocalDate.now().getYear()-18){
            throw new RequestException();
        }


        Cliente cliente = clienteConverter.convertDtoToEntity(clienteDTO);
        cliente = clienteRepository.save(cliente);
        
        return clienteConverter.convertEntityToDto(cliente);
    }

    public KpiCliente kpiCliente() {

        List<Integer> edadesList = new ArrayList<>();

        for (Cliente cliente: clienteRepository.findAll()) {
            edadesList.add(CalculosAuxiliares.getEdadPorFecha(cliente.getFechaNacimiento()));
        }
        Double edadPromedio = CalculosAuxiliares.getPromedio(edadesList);
        Double desvEstandarEdad = CalculosAuxiliares.getDesvEstandar(edadesList);

        return new KpiCliente(edadPromedio,desvEstandarEdad);
    }

}

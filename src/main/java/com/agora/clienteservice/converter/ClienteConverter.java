package com.agora.clienteservice.converter;

import com.agora.clienteservice.dto.ClienteDTO;
import com.agora.clienteservice.models.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ClienteConverter {


    public ClienteDTO convertEntityToDto(Cliente cliente) {
        ModelMapper modelMapper = new ModelMapper();
        ClienteDTO clienteDTO = modelMapper.map(cliente, ClienteDTO.class);
        return clienteDTO;
    }

    public Cliente convertDtoToEntity(ClienteDTO clienteDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        return cliente;
    }

}

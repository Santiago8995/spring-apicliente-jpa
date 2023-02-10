package com.agora.clienteservice.services;

import com.agora.clienteservice.converter.ClienteConverter;
import com.agora.clienteservice.dto.ClienteDTO;
import com.agora.clienteservice.models.Cliente;
import com.agora.clienteservice.repositories.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class ClienteServiceTest {


    @Mock
    private ClienteRepository repositorio;
    @InjectMocks
    private ClienteService clienteService;

    @InjectMocks
    private ClienteDTO clienteDTO;
    @Mock
    ClienteConverter clienteConverter;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void obtenerClientes() {
        long id = 1;
        Cliente clientedb = new Cliente(id,"Ramon","Diaz",LocalDate.parse("1989-01-01"));

        Mockito.when(repositorio.findAll()).thenReturn(Collections.singletonList(clientedb));
        assertNotNull(clienteService.listarClientes());

        System.out.println(clienteService.listarClientes());


    }

    @Test
    void crearCliente(){

        long id = 1;
        Cliente clientedb = new Cliente(id,"Ramon","Diaz",LocalDate.parse("1985-02-01"));
        ClienteDTO clientedto = new ClienteDTO(null,"Ramon","Diaz",LocalDate.parse("1985-02-01"),null,null);


        Mockito.when(clienteConverter.convertDtoToEntity(clienteDTO)).thenReturn(clientedb);
        Mockito.when(repositorio.save(clientedb)).thenReturn(clientedb);

        clienteService.crearCliente(clientedto);
        System.out.println(clienteService.crearCliente(clientedto));
    }

    @Test
    void kpiCliente() {
        long id = 1;
        Cliente clientedb = new Cliente(id,"Ramon","Diaz",LocalDate.parse("1989-01-01"));

        Mockito.when(repositorio.findAll()).thenReturn(Collections.singletonList(clientedb));
        assertNotNull(clienteService.kpiCliente());
        System.out.println(clienteService.kpiCliente());
    }

}
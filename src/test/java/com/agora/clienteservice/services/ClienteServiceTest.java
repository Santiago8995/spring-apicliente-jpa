package com.agora.clienteservice.services;

import com.agora.clienteservice.dao.ClienteDAO;
import com.agora.clienteservice.models.Cliente;
import com.agora.clienteservice.models.KpiCliente;
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

    @Mock
    ClienteDAO clienteDAO;

    @InjectMocks
    private ClienteService clienteService;

    private Cliente cliente;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);


        long id = 200;
        cliente = new Cliente();
        cliente.setId(id);
        cliente.setNombre("Carlos");
        cliente.setApellido("Perepe");
        cliente.setFechaNacimiento(LocalDate.parse("1989-01-01"));

    }

    @Test
    void obtenerClientes() {
        Mockito.when(repositorio.findAll()).thenReturn(Collections.singletonList(cliente));
        assertNotNull(clienteService.listarClientes());
    }

    @Test
    void crearCliente() throws Exception {


        Cliente.ClienteBuilder builder = Cliente.builder();
        builder.nombre("Ramon");
        builder.apellido("Gimenez");
        builder.fechaNacimiento(LocalDate.parse("1989-01-01"));
        Cliente cliente1 = builder.build();

        Mockito.when(clienteService.crearCliente(cliente1)).thenReturn(cliente1);
        assertNotNull(clienteService.crearCliente(cliente1));



    }

    @Test
    void kpiCliente() {
       KpiCliente kpiCliente = KpiCliente.builder().promedioEdades(25.5).desviacionEstandar(4.5).build();

        Mockito.when(clienteService.kpiCliente()).thenReturn(kpiCliente);

    }

}
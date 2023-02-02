package com.agora.clienteservice.services;

import com.agora.clienteservice.controllers.ClienteController;
import com.agora.clienteservice.dao.ClienteDAO;
import com.agora.clienteservice.models.Cliente;
import com.agora.clienteservice.models.KpiCliente;
import com.agora.clienteservice.repositories.ClienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.BDDMockito.given;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class ClienteServiceTest {


    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    private ClienteRepository repositorio;

    @Mock
    private ClienteDAO clienteDAO;

    @InjectMocks
    private ClienteService clienteService;

    private Cliente cliente;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(clienteService).build();


        long id = 200;
        cliente = new Cliente();
        cliente.setId(id);
        cliente.setNombre("Carlos");
        cliente.setApellido("Perepe");
        cliente.setEdad(27);
        cliente.setFechaNacimiento(LocalDate.parse("1989-01-01"));

    }

    @Test
    void obtenerClientes() {
        Mockito.when(repositorio.findAll()).thenReturn(Arrays.asList(cliente));
        assertNotNull(clienteService.obtenerClientes());
    }

    @Test
    void crearCliente() throws Exception {


        Cliente.ClienteBuilder builder = Cliente.builder();
        builder.nombre("Ramon");
        builder.apellido("Gimenez");
        builder.edad(34);
        builder.fechaNacimiento(LocalDate.parse("1989-01-01"));
        Cliente cliente1 = builder.build();

        Mockito.when(clienteService.crearCliente(cliente1)).thenReturn(cliente1);
        assertNotNull(clienteService.crearCliente(cliente1));



    }

    @Test
    void kpiCliente() {

        ArrayList<Integer> listaEdades = new ArrayList<Integer>(List.of(3, 1, 4));
        KpiCliente kpiCliente = KpiCliente.builder().promedioEdades(25.5).desviacionEstandar(4.5).build();

        Mockito.when(clienteDAO.getAllAge()).thenReturn(listaEdades);
/*Mockito.when(clienteService.kpiCliente()).thenReturn(kpiCliente);*/




    }

}
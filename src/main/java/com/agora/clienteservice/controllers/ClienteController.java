package com.agora.clienteservice.controllers;

import ch.qos.logback.core.net.server.Client;
import com.agora.clienteservice.models.Cliente;
import com.agora.clienteservice.models.KpiCliente;
import com.agora.clienteservice.repositories.ClienteRepository;
import com.agora.clienteservice.services.ClienteService;
import io.swagger.annotations.ApiOperation;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/v1/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;
    @Autowired
    private ClienteRepository clienteRepository;
@ApiOperation(value="Listar Clientes",notes= "Entrega una lista con los Clientes cargados en la Base de Datos.")
    @GetMapping("/listarclientes")
    public ResponseEntity<List<Cliente>> obtenerClientes() {
        return ResponseEntity.ok(clienteService.obtenerClientes());
    }
    @ApiOperation(value="Crear Cliente",notes= "Crea un Cliente y lo carga en la Base de Datos.")
    @PostMapping("/crearcliente")
    public ResponseEntity<Cliente> crearCliente(@RequestBody @Valid Cliente cliente) {
        return new ResponseEntity<Cliente>(clienteService.crearCliente(cliente), HttpStatus.CREATED);
    }
    @ApiOperation(value="Kpi Cliente",notes= "Entrega un promedio y desviacion estandar entre las edades de los clientes registrados.")
    @GetMapping("/kpicliente")
    public KpiCliente kpiCliente() {
        return ResponseEntity.ok(clienteService.kpiCliente()).getBody();
    }


}

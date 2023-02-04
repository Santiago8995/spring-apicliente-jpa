package com.agora.clienteservice.controllers;

import com.agora.clienteservice.models.Cliente;
import com.agora.clienteservice.services.ClienteService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/clientes")
public class ClienteController {


    @Autowired
    ClienteService clienteService;


@ApiOperation(value="Listar Clientes",notes= "Entrega una lista con los Clientes cargados en la Base de Datos.")
    @GetMapping("/listarclientes")
    public ResponseEntity<List<Cliente>> listarClientes() {
        return ResponseEntity.ok(clienteService.listarClientes());
    }
    @ApiOperation(value="Crear Cliente",notes= "Crea un Cliente y lo carga en la Base de Datos.")
    @PostMapping("/crearcliente")
    public ResponseEntity<Cliente> crearCliente(@RequestBody @Valid Cliente cliente) {
        return new ResponseEntity<Cliente>(clienteService.crearCliente(cliente), HttpStatus.CREATED);
    }
    @ApiOperation(value="Kpi Cliente",notes= "Entrega un promedio y desviacion estandar entre las edades de los clientes registrados.")
    @GetMapping("/kpicliente")
    public ResponseEntity kpiCliente() {
//        return ResponseEntity.ok(clienteService.kpiCliente()).getBody();
        return new ResponseEntity(clienteService.kpiCliente(), HttpStatus.FOUND);
    }


}

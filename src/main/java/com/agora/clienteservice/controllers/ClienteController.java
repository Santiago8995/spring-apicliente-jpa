package com.agora.clienteservice.controllers;

import com.agora.clienteservice.converter.ClienteConverter;
import com.agora.clienteservice.dto.ClienteDTO;
import com.agora.clienteservice.services.ClienteService;
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
    @Autowired
    private ClienteConverter clienteConverter;


    @GetMapping("/listarclientes")
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        return ResponseEntity.ok(clienteService.listarClientes());
    }


    @PostMapping("/crearcliente")
    public ResponseEntity<ClienteDTO> crearCliente(@RequestBody @Valid ClienteDTO cliente) {
        return new ResponseEntity<ClienteDTO>(clienteService.crearCliente(cliente), HttpStatus.CREATED);
    }


    @GetMapping("/kpicliente")
    public ResponseEntity kpiCliente() {

        return new ResponseEntity(clienteService.kpiCliente(), HttpStatus.OK);
    }


}

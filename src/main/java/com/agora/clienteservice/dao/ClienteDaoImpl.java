package com.agora.clienteservice.dao;

import antlr.ASTNULLType;
import antlr.actions.python.CodeLexer;
import ch.qos.logback.core.net.server.Client;
import com.agora.clienteservice.models.Cliente;
import com.agora.clienteservice.repositories.ClienteRepository;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ClienteDaoImpl implements ClienteDAO {

    @Autowired
    ClienteRepository clienteRepository;

    public ArrayList<Cliente> findAll(){
        return (ArrayList<Cliente>) clienteRepository.findAll();
    }

    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

   public ArrayList<Integer> getAllAge(){
        List<Integer> listaEdades = ((ArrayList<Cliente>) clienteRepository.findAll()).stream().map(Cliente::getEdad).collect(Collectors.toList());

        return (ArrayList<Integer>) listaEdades;
    }


}

package com.agora.clienteservice.repositories;

import com.agora.clienteservice.models.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c WHERE c.nombre = ?1")
    Collection<Cliente> findClienteBySurename(String apellido);

}
package com.dallase.api_rest.repository;

import org.springframework.data.repository.CrudRepository;

import com.dallase.api_rest.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}

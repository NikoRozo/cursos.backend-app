package com.api.app.clientes.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.api.app.clientes.model.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long> {

}

package com.api.app.clientes.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.app.clientes.model.entity.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Long> {

}

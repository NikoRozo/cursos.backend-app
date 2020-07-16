package com.api.app.clientes.model.services;

import java.util.List;

import com.api.app.clientes.model.entity.Cliente;

public interface IClienteService {

	public List<Cliente> findAll();
}

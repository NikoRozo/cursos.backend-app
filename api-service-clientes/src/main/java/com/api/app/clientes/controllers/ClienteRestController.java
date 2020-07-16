package com.api.app.clientes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.app.clientes.model.entity.Cliente;
import com.api.app.clientes.model.services.IClienteService;

@RestController
public class ClienteRestController {

	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/")
	public List<Cliente> index(){
		return clienteService.findAll();
	}
}

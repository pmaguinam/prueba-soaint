package com.pe.soaint.api.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.soaint.api.dto.Cliente;
import com.pe.soaint.api.repository.ClienteRepository;

@Service
public class ClienteDAO {

	@Autowired
	ClienteRepository clienteRepository;
	
	public Cliente registrarCliente (Cliente cliente) {
		return clienteRepository.save(cliente);
	}
}

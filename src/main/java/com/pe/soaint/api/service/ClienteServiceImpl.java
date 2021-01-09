package com.pe.soaint.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.soaint.api.dao.ClienteDAO;
import com.pe.soaint.api.dto.Cliente;
import com.pe.soaint.api.exception.BackEndException;



@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteDAO clienteDAO;
	
	@Override
	public void registrarCliente(Cliente clienteNuevo) {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente ();
		
		cliente = clienteDAO.registrarCliente(clienteNuevo);
		
		if (null == cliente) {
			
			throw new BackEndException("","","","Error al registrar al cliente");
		}
		
	}

}

package com.pe.soaint.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pe.soaint.api.dto.Cliente;
import com.pe.soaint.api.exception.BackEndException;
import com.pe.soaint.api.service.ClienteService;
import com.pe.soaint.api.type.ResponseClienteType;
import com.pe.soaint.api.type.ResponseStatusBase;

@RestController
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@PostMapping("cliente")
	public ResponseClienteType registrarCliente (@RequestBody Cliente request) {
		
		ResponseClienteType response = new ResponseClienteType();
		ResponseStatusBase status = new ResponseStatusBase();
		try {
			
			clienteService.registrarCliente(request);
			
			status.setHttpStatus(HttpStatus.OK);
			status.setMessage("");
			status.setCode("");
			status.setBackendMessage("Registro correcto");
			
		} catch (BackEndException e) {
			status.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			status.setMessage("");
			status.setCode("");
			status.setBackendMessage(e.getMessage());
		} catch (Exception e) {
			status.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			status.setMessage("");
			status.setCode("Error no controlado");
			status.setBackendMessage(e.getMessage());
		} finally {
			response.setDatosCliente(request);
			response.setStatus(status);
		}
		
		return response;
	}
}

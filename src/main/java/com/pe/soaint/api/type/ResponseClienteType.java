package com.pe.soaint.api.type;

import com.pe.soaint.api.dto.Cliente;

public class ResponseClienteType {

	private Cliente datosCliente;
	private ResponseStatusBase status;
	
	public Cliente getDatosCliente() {
		return datosCliente;
	}
	public void setDatosCliente(Cliente datosCliente) {
		this.datosCliente = datosCliente;
	}
	public ResponseStatusBase getStatus() {
		return status;
	}
	public void setStatus(ResponseStatusBase status) {
		this.status = status;
	}
}

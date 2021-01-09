package com.pe.soaint.api.type;

import com.pe.soaint.api.dto.Producto;

public class ResponseProductoType {

	private Producto datosProducto;
	private ResponseStatusBase status;
	
	public Producto getDatosProducto() {
		return datosProducto;
	}
	public void setDatosProducto(Producto datosProducto) {
		this.datosProducto = datosProducto;
	}
	public ResponseStatusBase getStatus() {
		return status;
	}
	public void setStatus(ResponseStatusBase status) {
		this.status = status;
	}
}

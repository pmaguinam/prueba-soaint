package com.pe.soaint.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pe.soaint.api.dto.Producto;
import com.pe.soaint.api.exception.BackEndException;
import com.pe.soaint.api.service.ProductoService;
import com.pe.soaint.api.type.ResponseProductoType;
import com.pe.soaint.api.type.ResponseStatusBase;

@RestController
public class ProductoController {

	@Autowired
	ProductoService productoService;
	
	@PostMapping("producto")
	public ResponseProductoType registrarProducto (@RequestBody Producto request) {
		
		ResponseProductoType response = new ResponseProductoType();
		ResponseStatusBase status = new ResponseStatusBase();
		try {
			productoService.registrarProducto(request);
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
			response.setDatosProducto(request);
			response.setStatus(status);
		}
		
		return response;
	}
	
	@GetMapping("producto/obtener/{idProducto}")
	public ResponseProductoType obtenerProducto (@PathVariable(value="idProducto") Long idProducto) {
		
		ResponseProductoType response = new ResponseProductoType();
		ResponseStatusBase status = new ResponseStatusBase();
		try {
			Producto producto = productoService.buscarProducto(idProducto);
			
			status.setHttpStatus(HttpStatus.OK);
			status.setMessage("");
			status.setCode("");
			status.setBackendMessage("Registro correcto");
			response.setDatosProducto(producto);
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
			
			response.setStatus(status);
		}
		
		return response;
	}
	
	@PutMapping("producto/actualizar")
	public ResponseProductoType actualizarProducto (@RequestBody Producto request) {
		
		ResponseProductoType response = new ResponseProductoType();
		ResponseStatusBase status = new ResponseStatusBase();
		try {
			productoService.actualizarProducto(request);
			
			status.setHttpStatus(HttpStatus.OK);
			status.setMessage("");
			status.setCode("");
			status.setBackendMessage("Actualizacion correcta");
			response.setDatosProducto(request);
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
			
			response.setStatus(status);
		}
		
		return response;
	}
	
	@DeleteMapping("producto/obtener/{idProducto}")
	public ResponseProductoType eliminarProducto (@PathVariable(value="idProducto") Long idProducto) {
		
		ResponseProductoType response = new ResponseProductoType();
		ResponseStatusBase status = new ResponseStatusBase();
		try {
			
			productoService.eliminarProducto(idProducto);
			
			status.setHttpStatus(HttpStatus.OK);
			status.setMessage("");
			status.setCode("");
			status.setBackendMessage("Eliminacion correcto");
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
			
			response.setStatus(status);
		}
		
		return response;
	}
}

package com.pe.soaint.api.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.soaint.api.dto.Producto;
import com.pe.soaint.api.repository.ProductoRepository;


@Service
public class ProductoDAO {

	@Autowired
	ProductoRepository productoRepository;
	
	public Producto registrarProducto (Producto producto) {
		return productoRepository.save(producto);
	}
		
	public Producto buscarProducto (Long idProducto) {
		return productoRepository.findFirstByIdProducto(idProducto);
		
	}
	
	public void eliminarProducto (Long idProducto) {
		productoRepository.deleteById(idProducto);
	}
}

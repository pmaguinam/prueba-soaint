package com.pe.soaint.api.service;

import com.pe.soaint.api.dto.Producto;

public interface ProductoService {

	public void registrarProducto (Producto productoNuevo);
	public void actualizarProducto(Producto producto);
	public void eliminarProducto(Long idProducto);
	public Producto buscarProducto(Long idProducto);
}

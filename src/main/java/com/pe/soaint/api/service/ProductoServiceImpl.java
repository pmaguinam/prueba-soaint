package com.pe.soaint.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.soaint.api.dao.ProductoDAO;
import com.pe.soaint.api.dto.Producto;
import com.pe.soaint.api.exception.BackEndException;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	ProductoDAO productoDAO;

	@Override
	public void registrarProducto(Producto productoNuevo) {
		// TODO Auto-generated method stub
		Producto producto = new Producto();
		producto = productoDAO.registrarProducto(productoNuevo);

		if (null == producto) {
			throw new BackEndException("","","","Error al registrar al producto");
		}
	}

	@Override
	public void actualizarProducto(Producto producto) {
		// TODO Auto-generated method stub
		Producto item = new Producto();

		item = productoDAO.buscarProducto(producto.getIdProducto());

		if (null != item) {
			productoDAO.registrarProducto(producto);
		}
	}

	@Override
	public void eliminarProducto(Long idProducto) {
		// TODO Auto-generated method stub

		productoDAO.eliminarProducto(idProducto);
	}

	@Override
	public Producto buscarProducto(Long idProducto) {
		// TODO Auto-generated method stub
		Producto producto = new Producto();

		producto = productoDAO.buscarProducto(idProducto);

		if (null == producto) {
			throw new BackEndException("","","","Error al buscar el producto");
		}

		return producto;
	}

}

package com.pe.soaint.api.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.soaint.api.dto.Venta;
import com.pe.soaint.api.repository.VentaRepository;

@Service
public class VentaDAO {

	@Autowired
	VentaRepository ventaRepository;
	
	public Venta registrarVenta (Venta venta) {
		return ventaRepository.save(venta);
	}
	
	public Venta consultarVenta (Long idVenta) {
		return ventaRepository.findFirstByIdventa(idVenta);
	}
}


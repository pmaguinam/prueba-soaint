package com.pe.soaint.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pe.soaint.api.dto.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {

	public Venta findFirstByIdventa (Long idVenta);
}

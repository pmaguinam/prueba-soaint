package com.pe.soaint.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pe.soaint.api.dto.Producto;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

	public Producto findFirstByIdProducto (Long idProducto); 
	
}

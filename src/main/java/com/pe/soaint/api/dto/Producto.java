package com.pe.soaint.api.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Producto")
public class Producto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idproducto;
	
	private String nombre;
	private String precio;
	
	public Long getIdProducto() {
		return idproducto;
	}
	public void setIdProducto(Long idproducto) {
		this.idproducto = idproducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
}

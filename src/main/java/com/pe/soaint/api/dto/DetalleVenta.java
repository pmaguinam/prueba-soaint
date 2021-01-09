package com.pe.soaint.api.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="DetalleVenta")
public class DetalleVenta {

	@EmbeddedId
	private Long iddetalleventa;

	@MapsId("idventa")
	@ManyToOne
	private Venta venta;

	@ManyToOne
	@JoinColumn(name = "idproducto")
	private Producto producto;

	public DetalleVenta() {
		
	}

	public Long getIddetalleventa() {
		return iddetalleventa;
	}



	public void setIddetalleventa(Long iddetalleventa) {
		this.iddetalleventa = iddetalleventa;
	}



	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
}

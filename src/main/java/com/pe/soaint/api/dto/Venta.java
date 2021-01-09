package com.pe.soaint.api.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Venta")
public class Venta {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idventa;
	
	@ManyToOne
    @JoinColumn(name = "idcliente")
	private Cliente cliente;
	
	private Date fecha;

	@OneToMany(mappedBy = "venta")
	private List<DetalleVenta> detalleVenta;
	
	public Long getIdventa() {
		return idventa;
	}

	public void setIdventa(Long idventa) {
		this.idventa = idventa;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}

package com.pe.soaint.api.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idcliente;
	
	private String nombre;
	private String apellido;
	private String dni;
	private String telefono;
	private String email;
	
	@OneToMany(mappedBy = "cliente")
	private List<Venta> ventas;
	
	public Long getIdCliente() {
		return idcliente;
	}
	public void setIdCliente(Long idcliente) {
		this.idcliente = idcliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}

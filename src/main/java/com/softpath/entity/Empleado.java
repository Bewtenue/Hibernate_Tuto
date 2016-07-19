package com.softpath.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Empleado {
	private String nombreEmpleado;
	private String direccionEmpleado;
	
	public String getNombreEmpleado() {
		return nombreEmpleado;
	}
	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}
	public String getDireccionEmpleado() {
		return direccionEmpleado;
	}
	public void setDireccionEmpleado(String direccionEmpleado) {
		this.direccionEmpleado = direccionEmpleado;
	}
	
	
}

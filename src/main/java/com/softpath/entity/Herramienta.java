package com.softpath.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Herramienta {
	private String nombreHerramienta;
	private String descripcion;
	
	public String getNombreHerramienta() {
		return nombreHerramienta;
	}
	public void setNombreHerramienta(String nombreHerramienta) {
		this.nombreHerramienta = nombreHerramienta;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}

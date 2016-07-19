package com.softpath.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Local {
	private String nombreLocal;
	private String direccionLocal;
	
	
	public String getNombreLocal() {
		return nombreLocal;
	}
	public void setNombreLocal(String nombreLocal) {
		this.nombreLocal = nombreLocal;
	}
	public String getDireccionLocal() {
		return direccionLocal;
	}
	public void setDireccionLocal(String direccionLocal) {
		this.direccionLocal = direccionLocal;
	}
	
	
}

package com.softpath.entity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Embeddable
public class SerializableDog implements Serializable{

	private static final long serialVersionUID = 1L;
	//@Id @GeneratedValue(strategy = GenerationType.AUTO)
	//private int id;
	@Column(name="nombrePerro")
	private String nombre;
	@Column(name="razaPerro")
	private String raza;
	@Column(name="colorPerro")
	private String color;
	
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString(){
		return "Nombre : "+this.nombre+" Raza : "+this.raza +" Color : "+this.color;
	}

	
	
}

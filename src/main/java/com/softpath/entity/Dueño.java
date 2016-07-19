package com.softpath.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dueño")

public class Dueño {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	private String edad;
	@Embedded
	private Address address;
	@Embedded
	private SerializableDog dog;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public SerializableDog getDog() {
		return dog;
	}
	public void setDog(SerializableDog dog) {
		this.dog = dog;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}

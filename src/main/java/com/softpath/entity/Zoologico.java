package com.softpath.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Zoologico {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int idZoo;
	private String nameZoo;
	@ManyToOne()
	//usamos esto para crear una tabla que relacione los 2 campos
	private Animales animal;
	
	
	public int getIdZoo() {
		return idZoo;
	}
	public void setIdZoo(int idZoo) {
		this.idZoo = idZoo;
	}
	public String getNameZoo() {
		return nameZoo;
	}
	public void setNameZoo(String nameZoo) {
		this.nameZoo = nameZoo;
	}
	public Animales getAnimal() {
		return animal;
	}
	public void setAnimal(Animales animal) {
		this.animal = animal;
	}
	
	
}

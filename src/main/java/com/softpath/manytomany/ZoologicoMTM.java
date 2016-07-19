package com.softpath.manytomany;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class ZoologicoMTM {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int idZoo;
	private String nameZoo;
	@ManyToMany
	//usamos esto para crear una tabla que relacione los 2 campos
	private Collection <AnimalesMTM> animal = new ArrayList<AnimalesMTM>();
	
	
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
	public Collection<AnimalesMTM> getAnimal() {
		return animal;
	}
	public void setAnimal(Collection<AnimalesMTM> animal) {
		this.animal = animal;
	}
	
	
	
}

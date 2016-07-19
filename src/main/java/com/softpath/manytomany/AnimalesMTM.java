package com.softpath.manytomany;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class AnimalesMTM {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	//para agregar one to many
	@ManyToMany(mappedBy="animal")
	/*@JoinTable(name="ANIMAL_ZOO", joinColumns=@JoinColumn(name="ANIMALES_ID"),
	inverseJoinColumns=@JoinColumn(name="ZOO_ID"))
	 * */
	private Collection <ZoologicoMTM> zoo = new ArrayList<ZoologicoMTM>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<ZoologicoMTM> getZoo() {
		return zoo;
	}
	public void setZoo(Collection<ZoologicoMTM> zoo) {
		this.zoo = zoo;
	}
	
	
}

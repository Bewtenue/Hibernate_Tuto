package com.softpath.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="autores_table")
public class Autores {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String nameAutor;
	private String lastNameAutor;
	@ElementCollection(fetch=FetchType.EAGER)//EAGER sirve para sacar los datos de la coleccion
	@JoinTable(name="List_of_Paints",
		joinColumns=@JoinColumn(name="Autores_listofPaints"))
	@GenericGenerator(name="sequence-gen", strategy="sequence")
	@CollectionId(columns={@Column(name="Paint_Id")},generator="sequence-gen" ,
	type = @Type(type = "long"))
	//private Set<Paint> listofPaints = new HashSet<Paint>();
	private List<Paint> listofPaints = new ArrayList<Paint>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNameAutor() {
		return nameAutor;
	}
	public void setNameAutor(String nameAutor) {
		this.nameAutor = nameAutor;
	}
	public String getLastNameAutor() {
		return lastNameAutor;
	}
	public void setLastNameAutor(String lastNameAutor) {
		this.lastNameAutor = lastNameAutor;
	}
	public List<Paint> getListofPaints() {
		return listofPaints;
	}
	public void setListofPaints(List<Paint> listofPaints) {
		this.listofPaints = listofPaints;
	}
	
	
	
}

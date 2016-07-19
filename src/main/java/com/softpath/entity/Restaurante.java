package com.softpath.entity;

import java.util.ArrayList;
import java.util.List;

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
@Table(name="restaurante_table")
public class Restaurante {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private Local local;
	
	//////EMPLEADO EAGER
	@ElementCollection(fetch=FetchType.EAGER)//EAGER sirve para sacar los datos de la coleccion
	@JoinTable(name="List_of_Empleado",
		joinColumns=@JoinColumn(name="Autores_listofEmpleado"))
	@GenericGenerator(name="sequence-gen", strategy="sequence")
	@CollectionId(columns={@Column(name="Empleado_Id")},generator="sequence-gen" ,
	type = @Type(type = "long"))
	
	////HERRAMIENTA LAZY
	private List<Empleado> listofEmpleado = new ArrayList<Empleado>();
	@ElementCollection(fetch=FetchType.LAZY)//EAGER sirve para sacar los datos de la coleccion
	@JoinTable(name="List_of_Herramienta",
		joinColumns=@JoinColumn(name="Restaurante_listofHerramienta"))
	@GenericGenerator(name="sequence-gen", strategy="sequence")
	@CollectionId(columns={@Column(name="Herramienta_Id")},generator="sequence-gen" ,
	type = @Type(type = "long"))
	private List<Herramienta> listofHerramienta = new ArrayList<Herramienta>();
	
	
	public Local getLocal() {
		return local;
	}
	public void setLocal(Local local) {
		this.local = local;
	}
	
	
	public List<Empleado> getListofEmpleado() {
		return listofEmpleado;
	}
	public void setListofEmpleado(List<Empleado> listofEmpleado) {
		this.listofEmpleado = listofEmpleado;
	}
	public List<Herramienta> getListofHerramienta() {
		return listofHerramienta;
	}
	public void setListofHerramienta(List<Herramienta> listofHerramienta) {
		this.listofHerramienta = listofHerramienta;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}

package com.softpath.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity //@entity tiene que estar siempre en el POJO
@Table(name="UserDetails")

public class UserDetails {
	//se puede usar la notacion ID y le podemos decir como genere los id
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	//tambien se puede cambiar el nombre de la columna
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@Temporal(TemporalType.DATE)//para cambiar el dato que se va a guardar en el date
	private Date joinedDate;
	
	@Lob
	@Transient
	private String description;
	
	@Embedded
	private Address addressHome;
	
	@Embedded
	//@AttributeOverride(name="street", column=@Column(name="office_street_column"))esto es para un solo atributo
	@AttributeOverrides({
		@AttributeOverride(name="street", column=@Column(name="office_street_column")),
		@AttributeOverride(name="city", column=@Column(name="office_city_column")),
		@AttributeOverride(name="state", column=@Column(name="office_state_column"))
	})
	private Address adressOffice;
	
	//////GETTERS AND SETTERS
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Address getAddressHome() {
		return addressHome;
	}
	public void setAddressHome(Address address) {
		this.addressHome = address;
	}
	public Address getAdressOffice() {
		return adressOffice;
	}
	public void setAdressOffice(Address adressOffice) {
		this.adressOffice = adressOffice;
	}
	
	
}

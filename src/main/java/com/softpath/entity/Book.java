package com.softpath.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Entity
@Table(name="BookDetails")
public class Book {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idLibro")
	private int bookId;
	@Column(name="titulo")
	private String title;
	@Column(name="noPaginas")
	private String numPages;
	@Column(name="autor")
	private String author;
	@Transient
	@Column(name="descripcion")
	private String description;
	@Column(name="fechaPub")
	@Temporal(TemporalType.DATE)
	private Date pubDate;
	
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}


	
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getNoPag() {
		return numPages;
	}
	public void setNoPag(String noPag) {
		this.numPages = noPag;
	}
	public String getAutor() {
		return author;
	}
	public void setAutor(String autor) {
		this.author = autor;
	}
	public String getDescripcion() {
		return description;
	}
	public void setDescripcion(String descripcion) {
		this.description = descripcion;
	}
	public Date getFechaPublicacion() {
		return pubDate;
	}
	public void setFechaPublicacion(Date fechaPublicacion) {
		this.pubDate = fechaPublicacion;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String titulo;
		String numPags;
		String autor;
		Date fechaPub;
		int opcion = 0;
		int i = 0;
		Book libro[] = new Book[10];
		SimpleDateFormat dias = new SimpleDateFormat("yyyy");
		
		
		do{
		System.out.println("Selecciona una opcion del menu");
		System.out.println("1.Ingresar Libro");
		System.out.println("2.Salir");
		opcion = sc.nextInt();
			if(opcion ==1){
				System.out.println("Escribe el titulo del libro");
				titulo = sc.nextLine();
				titulo = sc.nextLine();
				System.out.println("Escribe la cantidad de paginas");
				numPags = sc.nextLine();
				System.out.println("Escribre el nombre del autor");
				autor = sc.nextLine();
				System.out.println("Escribe la fecha de publicacion");
				//fechaPub =
				libro[i] = new Book();
				libro[i].setAutor(autor);
				libro[i].setTitle(titulo);
				libro[i].setNoPag(numPags);
				//libro[i].setFechaPublicacion(fechaPub);
			
			}
			else{
				break;
			}
			i++;
		}while(opcion!=2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		for(Book l: libro){
			session.save(l);
		}
		session.getTransaction().commit();
		session.close();
	}
	
}

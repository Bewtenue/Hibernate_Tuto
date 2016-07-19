package com.softpath.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.softpath.entity.Animales;
import com.softpath.entity.Zoologico;

public class RelationsMain {
	
	public static void main(String[] args) {
		Animales animal = new Animales();
		animal.setName("Tigre");
		
		Zoologico zoo = new Zoologico();
		zoo.setNameZoo("Zoologico de Guadalajara");
		
		Zoologico zoo1 = new Zoologico();
		zoo1.setNameZoo("African Safari");
		
		zoo.setAnimal(animal);
		zoo1.setAnimal(animal);
		animal.getZoo().add(zoo);
		animal.getZoo().add(zoo1);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(animal);
		session.save(zoo);
		session.save(zoo1);
		session.getTransaction().commit();
		session.close();
		
	}
}

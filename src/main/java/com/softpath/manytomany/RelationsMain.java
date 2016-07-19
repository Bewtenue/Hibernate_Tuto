package com.softpath.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class RelationsMain {
	
	public static void main(String[] args) {
		AnimalesMTM animal = new AnimalesMTM();
		animal.setName("Tigre");
		
		ZoologicoMTM zoo = new ZoologicoMTM();
		zoo.setNameZoo("Zoologico de Guadalajara");
		
		ZoologicoMTM zoo1 = new ZoologicoMTM();
		zoo1.setNameZoo("African Safari");
		
		zoo.getAnimal().add(animal);
		zoo1.getAnimal().add(animal);
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

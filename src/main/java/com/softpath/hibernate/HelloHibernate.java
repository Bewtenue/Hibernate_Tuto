package com.softpath.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.softpath.entity.Address;
import com.softpath.entity.UserDetails;

public class HelloHibernate {
	
	public static void main(String[] args) {
		
		UserDetails user = new UserDetails();
		user.setUserName("Jesus");
		user.setJoinedDate(new Date());
		user.setDescription("This is my first user");
		
		UserDetails user1 = new UserDetails();
		user1.setUserName("Isabel");
		user1.setJoinedDate(new Date());
		user1.setDescription("This is my second user");
		
		Address address = new Address();
		address.setCity("Zapopan");
		address.setState("Jalisco");
		address.setStreet("Turquesa");
		
		Address addressoffice = new Address();
		addressoffice.setCity("Guadalajara");
		addressoffice.setState("Jalisco");
		addressoffice.setStreet("A las montañas");
		
		user.setAddressHome(address);
		user.setAdressOffice(addressoffice);
		user1.setAdressOffice(addressoffice);
		user1.setAddressHome(address);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(user);
		session.save(user1);
		session.getTransaction().commit();
		session.close();
		
		
	}
	
}

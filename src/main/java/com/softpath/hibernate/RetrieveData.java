package com.softpath.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.softpath.entity.UserDetails;

public class RetrieveData {
	
	public static void main(String[] args) {
		
		UserDetails user = new UserDetails();
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		user = (UserDetails)session.get(UserDetails.class, 1);
		System.out.println(user.getUserName());
		session.close();
		
		
		
	}
	
	
}

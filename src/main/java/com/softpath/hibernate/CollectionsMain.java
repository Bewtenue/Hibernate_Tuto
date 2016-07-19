package com.softpath.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.softpath.entity.Autores;
import com.softpath.entity.Paint;

public class CollectionsMain {
	
	public static void main(String[] args) {
		
		Autores autor = new Autores();
		autor.setNameAutor("Rafael");
		autor.setLastNameAutor("Sanzio");
		
		Paint paint = new Paint();
		paint.setNamePaint("Cartones de Rafael");
		paint.setYearPaint("1511");
		
		Paint paint1 = new Paint();
		paint1.setNamePaint("Madonna Sixtina");
		paint1.setYearPaint("1512");
		
		autor.getListofPaints().add(paint);
		autor.getListofPaints().add(paint1);
		

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(autor);
		session.getTransaction().commit();
		session.close();
		
		Autores autor1 = null;
		///EAGER AND LAZY
		
		session = sessionFactory.openSession();
		autor1 = (Autores) session.get(Autores.class, 1);
		//System.out.println(autor1.getListofPaints().size()); //cuando es posible ver los datos fuera de la session
		session.close();
		System.out.println(autor1.getListofPaints().size());//cuando es lazy aqui manda una excepcion
		
	}
	
}

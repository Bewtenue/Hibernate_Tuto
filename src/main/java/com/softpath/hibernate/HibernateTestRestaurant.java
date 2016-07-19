package com.softpath.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.softpath.entity.Autores;
import com.softpath.entity.Empleado;
import com.softpath.entity.Herramienta;
import com.softpath.entity.Local;
import com.softpath.entity.Restaurante;

public class HibernateTestRestaurant {
	
	public static void main(String[] args) {
		Restaurante rest = new Restaurante();
		Local local = new Local();
		Empleado emp1 = new Empleado();
		Empleado emp2 = new Empleado();
		Herramienta herramienta1 = new Herramienta();
		Herramienta herramienta2 = new Herramienta();
		
		local.setNombreLocal("Pipiolo");
		local.setDireccionLocal("Av. Mariano Otero");
		emp1.setNombreEmpleado("Jesus");
		emp1.setDireccionEmpleado("A las montañas");
		emp2.setNombreEmpleado("Roberto");
		emp2.setDireccionEmpleado("A las llanuras");
		herramienta1.setNombreHerramienta("Freidora");
		herramienta1.setDescripcion("Sirve para freir cosas");
		herramienta2.setNombreHerramienta("Horno");
		herramienta2.setDescripcion("Sirve para calentar cosas");
		rest.setLocal(local);
		rest.getListofEmpleado().add(emp1);
		rest.getListofEmpleado().add(emp2);
		rest.getListofHerramienta().add(herramienta1);
		rest.getListofHerramienta().add(herramienta2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(rest);
		session.getTransaction().commit();
		session.close();
		
		Restaurante rest1 = null;
		
		session = sessionFactory.openSession();
		rest1 = (Restaurante) session.get(Restaurante.class, 1);
		
		session.close();
		System.out.println(rest1.getListofEmpleado().size());//EAGER
		
		
	}
	
}

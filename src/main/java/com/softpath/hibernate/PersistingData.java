package com.softpath.hibernate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.softpath.entity.Address;
import com.softpath.entity.Dueño;
import com.softpath.entity.SerializableDog;

public class PersistingData {
	public static void main(String[] args) {
		Dueño dueño[] = new Dueño[5];
		dueño[0] = new Dueño();
		dueño[0].setNombre("Jesus");
		dueño[0].setEdad("24");
		dueño[1] = new Dueño();
		dueño[1].setNombre("Alfonso");
		dueño[1].setEdad("29");
		dueño[2] = new Dueño();
		dueño[2].setNombre("Jiamin");
		dueño[2].setEdad("27");
		dueño[3] = new Dueño();
		dueño[3].setNombre("Aldo");
		dueño[3].setEdad("23");
		dueño[4] = new Dueño();
		dueño[4].setNombre("Rafael");
		dueño[4].setEdad("26");
		
		//direccion
		Address address1 = new Address();
		address1.setCity("Zapopan");
		address1.setState("Jalisco");
		address1.setStreet("Turquesa");
		//perro
		SerializableDog dog[] = new SerializableDog[5];
		dog[0] = new SerializableDog();
		dog[0].setNombre("Frejya");
		dog[0].setRaza("Chihuahua");
		dog[0].setColor("Negro");
		dog[1] = new SerializableDog();
		dog[1].setNombre("Pucca");
		dog[1].setRaza("Chihuahua");
		dog[1].setColor("Amarilla");
		dog[2] = new SerializableDog();
		dog[2].setNombre("Kira");
		dog[2].setRaza("Yorkshire Terrier");
		dog[2].setColor("Cafe");
		dog[3] = new SerializableDog();
		dog[3].setNombre("Torrent");
		dog[3].setRaza("Chow Chow");
		dog[3].setColor("Negro");
		dog[4] = new SerializableDog();
		dog[4].setNombre("Lias");
		dog[4].setRaza("Caniche");
		dog[4].setColor("Blanco");
		//poniendolos en dueño
		//dueño1.setDog(dog1);
		
		
		/////////////////SERIALIZACION///////////
		LinkedList<SerializableDog> linkedList = new LinkedList<SerializableDog>();
		linkedList.add(dog[0]);
		linkedList.add(dog[1]);
		linkedList.add(dog[2]);
		linkedList.add(dog[3]);
		linkedList.add(dog[4]);
		
		try
		{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SerializableDog.txt"));
			oos.writeObject(linkedList);
			oos.close();
			System.out.println(linkedList);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Archivo no encontrado");
		}
		catch(IOException e)
		{
			System.out.println("Excepcion en la entrada/salida de datos");
		}
		///DE-SERIALIZACION
		try{
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("SerializableDog.txt"));
			LinkedList<SerializableDog> obj = (LinkedList<SerializableDog>)is.readObject();			
			System.out.println("DESPUES DEL DE-SERIALIZE");			
			if(obj != null )
			{
				int i = 0;
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				
				for (SerializableDog dogs : obj) {
					System.out.println(dogs);
					dueño[i].setDog(dog[i]);
					dueño[i].setAddress(address1);
					session.beginTransaction();
					session.save(dueño[i]);
					session.getTransaction().commit();
					
					i++;
				} 
				session.close();
			}
		}
		catch(FileNotFoundException f)
		{
			System.out.println("File not found");
		}
		catch(IOException e)
		{
		//	System.out.println(e.getMessage());
		}
		
		catch(ClassNotFoundException ec)
		{
			System.out.println("Clase no encontrada");
		}
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		//session.save();
		session.getTransaction().commit();
		session.close();
		
	}
}

package com.hibernate.HibernateCfg;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	SessionFactory factory = new Configuration().configure().buildSessionFactory();
    	
    	Student student = new Student();
    	student.setId(21);
    	student.setName("Manan");
    	student.setCity("London");
    	
    	Address address = new Address();
    	address.setStreet("Baker street");
    	address.setCity("London");
    	address.setInIndia(false);
    	address.setAddedDate(new Date());
    	
    	FileInputStream fis = new FileInputStream("src/main/java/bird");
    	byte[] data = new byte[fis.available()];
    	fis.read(data);
    	address.setImage(data);
    	
    	Session session = factory.openSession();
    	
    	Transaction tx = session.beginTransaction();
    	session.save(student);
    	session.save(address);
    	tx.commit();
    	
    	session.close();
    	
    }
}

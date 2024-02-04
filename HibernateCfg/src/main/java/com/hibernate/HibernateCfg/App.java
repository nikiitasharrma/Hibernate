package com.hibernate.HibernateCfg;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory factory = new Configuration().configure().buildSessionFactory();
    	
    	Student student = new Student();
    	student.setId(20);
    	student.setName("Nikita");
    	student.setCity("Jaipur");
    	
    	Session session = factory.openSession();
    	
    	Transaction tx = session.beginTransaction();
    	session.save(student);
    	tx.commit();
    	
    	session.close();
    	
    }
}

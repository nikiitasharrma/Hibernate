package com.hibernate.HibernateCaching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FirstLevelCaching {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();

		Company c = new Company();
		c.setName("Turvo");
		c.setCity("Hyderabad");

		session.save(c);

		Transaction tx = session.beginTransaction();

		tx.commit();
		
		System.out.println(session.contains(c));
		
		session.close();
		
		//throws an IllegalStateException
		System.out.println(session.contains(c)); 
		
		factory.close();
	}
}

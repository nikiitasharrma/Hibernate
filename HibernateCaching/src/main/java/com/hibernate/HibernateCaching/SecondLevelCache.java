package com.hibernate.HibernateCaching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SecondLevelCache {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session1 = factory.openSession();

		Company c1 = session1.get(Company.class, 1);

		System.out.println(session1.contains(c1));

		session1.close();

		Session session2 = factory.openSession();

		Company c2 = session2.get(Company.class, 1);

		System.out.println(session2.contains(c2));

		session2.close();

		factory.close();

	}
}

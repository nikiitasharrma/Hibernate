package com.hibernate.HQL;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        
        Session session = factory.openSession();
        
        Company c1 = new Company();
        c1.setName("Infosys");
        c1.setCity("Gurugram");
        
        Company c2 = new Company();
        c2.setName("TCS");
        c2.setCity("Noida");
        
        Company c3 = new Company();
        c3.setName("Moody's");
        c3.setCity("Bangalore");
        
        Company c4 = new Company();
        c4.setName("PTC");
        c4.setCity("Noida");
        
        session.save(c1);
        session.save(c2);
        session.save(c3);
        session.save(c4);
        
        Transaction tx = session.beginTransaction();
        
        tx.commit();
        
        //making HQL queries to fetch records
        String query = "from Company";
        
        Query q = session.createQuery(query);
        
        List<Company> companies = q.getResultList();
        
        for(Company c : companies) {
        	System.out.println(c.getName());
        }
        
      //WHERE clause
        String query2 = "from Company where city='Gurugram'";
        
        Query q2 = session.createQuery(query2);
        
        List<Company> companies2 = q2.getResultList();
        
        for(Company c : companies2) {
        	System.out.println(c.getName());
        }
        
      //parameters
        String query3 = "from Company where city=:x and name=:n";
        
        Query q3 = session.createQuery(query3);
        q3.setParameter("x", "Noida");
        q3.setParameter("n", "PTC");
        
        List<Company> companies3 = q3.getResultList();
        
        for(Company c : companies3) {
        	System.out.println(c.getName());
        }
        
        session.close();
        
        factory.close();
    }
}

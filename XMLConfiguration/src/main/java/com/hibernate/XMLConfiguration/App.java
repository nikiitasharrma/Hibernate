package com.hibernate.XMLConfiguration;

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
        
        Client c = new Client();
        c.setName("Bonusly");
        c.setCity("London");
        
        Transaction tx = session.beginTransaction();
        
        session.save(c);
        
        tx.commit();
        
        session.close();
        
        factory.close();
    }
}

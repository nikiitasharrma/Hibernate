package com.hibernate.HQL;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class SQLNative {
	
	public static void main( String[] args )
    {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        
        Session session = factory.openSession();
       
        String query = "select * from Company";
        
        NativeQuery q = session.createNativeQuery(query);
        
        List<Object[]> companies = q.getResultList();
        
        for(Object[] c : companies) {
        	System.out.println(Arrays.toString(c));
        }

        session.close();
        factory.close();
    }
}

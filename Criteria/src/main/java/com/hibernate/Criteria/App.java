package com.hibernate.Criteria;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        //create criteria query for Client entity
        CriteriaQuery<Client> query = builder.createQuery(Client.class);
        //create root entity and query criteria
        Root<Client> root = query.from(Client.class);
        query.select(root);
        query.where(builder.equal(root.get("city"),"London"));
        query.where(builder.gt(root.get("id").as(Integer.class), 5));
        //execute query
        List<Client> list = session.createQuery(query).getResultList();
        
        for(Client c : list) {
        	System.out.println(c);
        }
    }
}

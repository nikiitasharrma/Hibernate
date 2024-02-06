package com.hibernate.ManyToManyRelationship;

import java.util.LinkedList;
import java.util.List;

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
        
        Employee nikita = new Employee();
        nikita.setName("Nikita Sharma");
        
        Employee harsh = new Employee();
        harsh.setName("Harsh Singh");
        
        Employee nisha = new Employee();
        nisha.setName("Nisha Mishra");
        
        Project chatBot = new Project();
        chatBot.setName("Chat bot");
        
        Project ecommerce = new Project();
        ecommerce.setName("E-commerce");
        
        Project blog = new Project();
        blog.setName("Blog website");
        
        List<Employee> e1 = new LinkedList<>();
        e1.add(nisha);
        e1.add(harsh);
        
        List<Employee> e2 = new LinkedList<>();
        e2.add(harsh);
        e2.add(nikita);
        
        List<Employee> e3 = new LinkedList<>();
        e3.add(nikita);
        e3.add(nisha);
        
        List<Project> p1 = new LinkedList<>();
        p1.add(ecommerce);
        p1.add(blog);
        
        List<Project> p2 = new LinkedList<>();
        p2.add(blog);
        p2.add(chatBot);
        
        List<Project> p3 = new LinkedList<>();
        p3.add(chatBot);
        p3.add(ecommerce);
        
        nikita.setProject(p1);
        harsh.setProject(p2);
        nisha.setProject(p3);
        
        chatBot.setEmployee(e1);
        ecommerce.setEmployee(e3);
        blog.setEmployee(e2);
        
        Transaction tx = session.beginTransaction();
        
        session.save(nikita);
        session.save(harsh);
        session.save(nisha);
        session.save(chatBot);
        session.save(ecommerce);
        session.save(blog);
        
        tx.commit();
        
        //fetching records
        Employee emp = session.get(Employee.class, 1);
        List<Project> list = emp.getProject();
        
        for(Project p : list) {
        	System.out.println(p.getName());
        }
        
        Project pro = session.get(Project.class, 1);
        List<Employee> plist = pro.getEmployee();
        
        for(Employee e : plist) {
        	System.out.println(e.getName());
        }
        session.close();
        
        factory.close();
    }
}

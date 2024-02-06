package com.hibernate.OneToManyRelationship;

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
        
        Person person = new Person();
        person.setId(122);
        person.setName("Nikita Sharma");
        
        Account personalAccount = new Account();
        personalAccount.setId(1221);
        personalAccount.setType("Personal account");
        personalAccount.setPerson(person);
        
        Account jointAccount = new Account();
        jointAccount.setId(1222);
        jointAccount.setType("Joint account");
        jointAccount.setPerson(person);
        
        Account savingsAccount = new Account();
        savingsAccount.setId(1223);
        savingsAccount.setType("Savings account");
        savingsAccount.setPerson(person);
        
        List<Account> accountsList = new LinkedList<>();
        accountsList.add(personalAccount);
        accountsList.add(jointAccount);
        accountsList.add(savingsAccount);
        
        person.setAccounts(accountsList);
        

        Transaction tx = session.beginTransaction();
        
        session.save(person);
        session.save(personalAccount);
        session.save(jointAccount);
        session.save(savingsAccount);
        
        
        tx.commit();
        
        session.close();
        
        factory.close();
        
    }
}

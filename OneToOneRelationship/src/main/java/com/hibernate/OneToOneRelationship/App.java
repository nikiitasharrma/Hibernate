package com.hibernate.OneToOneRelationship;

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
        
        Transaction tx = session.beginTransaction();
        
        Question question = new Question();
        question.setQues("What is collection framework?");
        
        Answer answer = new Answer();
        answer.setAns("Api to work with objects");
        
        question.setAnswer(answer);
        
        session.save(question);
        session.save(answer);
        
        tx.commit();
        
        //fetch
        Question ques = (Question) session.get(Question.class, 3);
        System.out.println(ques.getQues());
        System.out.println(ques.getAnswer());
        System.out.println(ques.getAnswer().getQues());
        
        session.close();
        factory.close();
    }
}

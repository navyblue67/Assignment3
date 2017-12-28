/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3.dao;

/**
 *
 * @author user
 */
import java.util.*;
import assignment3.model.Quiz;
import assignment3.model.Quiz_question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QuizDAOImpl implements QuizDAO{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sessionFactory){
     this.sessionFactory = sessionFactory;
  }

    @Override
    public void addQuiz(Quiz quiz) {
        sessionFactory.getCurrentSession().saveOrUpdate(quiz); 
    }
    
    @Override
    public void addQuestions(Quiz quiz, List<Quiz_question> question)
    {
        int marks = 0;
        Iterator<Quiz_question> itr = question.iterator();
        while(itr.hasNext())
        {
            Transaction trns = null;
            Session session = this.sessionFactory.openSession();
            trns = session.beginTransaction();
            quiz.addQuestion(itr.next());
            session.saveOrUpdate(quiz);
            session.getTransaction().commit();
            session.close();   
        }
        Iterator<Quiz_question> itr1 = question.iterator();
        while(itr1.hasNext())
        {
            marks += itr1.next().getMarks();
        }
        Transaction trns = null;
        Session session = this.sessionFactory.openSession();
        trns = session.beginTransaction();
        quiz.setMarks(marks);
        session.saveOrUpdate(quiz);
        session.getTransaction().commit();
        session.close();
               
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Quiz> getAllQuizzes() {
       return sessionFactory.getCurrentSession().createQuery("FROM Quiz").getResultList();
    }
}

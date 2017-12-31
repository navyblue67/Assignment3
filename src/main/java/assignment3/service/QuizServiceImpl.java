/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3.service;

/**
 *
 * @author user
 */
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import assignment3.dao.QuizDAO;
import assignment3.model.Quiz;
import assignment3.model.Quiz_question;

@Service
@Transactional
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizDAO quizDAO;

    @Override
    @Transactional
    public void addQuiz(Quiz quiz) {
        quizDAO.addQuiz(quiz); 
    }

    @Override
    @Transactional
    public List<Quiz_question> getQuizByTitle(String quiztitle)
    {
        return quizDAO.getQuizByTitle(quiztitle);
    }
    @Override
    @Transactional
    public List<Quiz> getAllQuizzes() {
        return quizDAO.getAllQuizzes();
    }
    
    @Override
    @Transactional
    public void addQuestions(Quiz quiz, List<Quiz_question> question) {
        quizDAO.addQuestions(quiz, question);
    }
    
}

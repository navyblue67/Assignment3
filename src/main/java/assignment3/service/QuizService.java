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
import assignment3.model.Quiz;
import assignment3.model.Quiz_question;

public interface QuizService {
    
    public void addQuiz(Quiz quiz);
    public List<Quiz> getAllQuizzes();
    public void addQuestions(Quiz quiz, List<Quiz_question> question);
    public List<Quiz_question> getQuizByTitle(String quiztitle);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3.controller;

/**
 *
 * @author user
 */
import assignment3.model.Quiz;
import assignment3.model.Quiz_question;
import java.io.IOException;
import java.util.List;
 
import javax.servlet.http.HttpServletRequest;
 
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import assignment3.model.Users;
import assignment3.service.QuestService;
import assignment3.service.QuizService;
import assignment3.service.UserService;
import java.util.Iterator;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private static final Logger logger = Logger
            .getLogger(UserController.class);
    private Quiz quiz1;
    
    @Autowired
    private UserService userService;
    @Autowired
    private QuizService quizService;
    @Autowired
    private QuestService question;
    
    
    
    @RequestMapping(value = "/")
    @ResponseBody
    public List<Users> listUser() throws IOException {
        List<Users> listUsers = userService.getAllUsers();
        return listUsers;
    }
    
    @RequestMapping(value = "/quiz")
    @ResponseBody
    public List<Quiz> viewQuiz () {
        List<Quiz> listQuiz = quizService.getAllQuizzes();
        return listQuiz;
    }
    
    @RequestMapping(value = "/getquiz", method = RequestMethod.GET)
    @ResponseBody
    public List<Quiz_question> getQuiz (@RequestParam(value = "title") String title) {
        List<Quiz_question> questions = quizService.getQuizByTitle(title);
        return questions;
        
        
    }

    
   
    
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST,  headers = "Accept=application/json")
    public void addUser (@RequestBody Users user) {
        userService.addUser(user);
        
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public Users getUser (@RequestParam(value = "username") String Login) {
        Users newuser = userService.getUser(Login);
        return newuser;
        
        
    }
    
    
    @RequestMapping(value = "/savequiz", method = RequestMethod.POST,  headers = "Accept=application/json")
    public void addQuiz (@RequestBody Quiz quiz) {
        quizService.addQuiz(quiz);
        quiz1 = quiz;
        
    }
    
    @RequestMapping(value = "/savequestion", method = RequestMethod.POST,  headers = "Accept=application/json")
    public void addQuestions (@RequestBody List<Quiz_question> questions) {
        Iterator<Quiz_question> questioniterator = questions.iterator();
        while(questioniterator.hasNext()){
           
            question.addQuest(questioniterator.next());
        }
        quizService.addQuestions(quiz1, questions);
        
    }
    
    
    
   
    
}

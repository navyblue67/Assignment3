/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author user
 */
@Entity
@Table(name= "question")
public class Quiz_question implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private int ID;
    private String question;
    private String answer;
    private int marks;
    
    
    
    public Quiz_question() {
    }

    public Quiz_question(String question, String answer, int marks) {
        this.question = question;
        this.answer = answer;
        this.marks = marks;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
    

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

   
    
 
 
}

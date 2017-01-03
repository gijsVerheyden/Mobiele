package com.example.wolkje.aphasia;

import java.util.ArrayList;

/**
 * Created by Wolkje on 3/01/2017.
 */

public abstract class Question {
    private String question;
    private String answer;
    private ArrayList<String> possibleAnswers; //also contains answer

    public Question(String question, String answer, ArrayList<String> possibleAnswers){
        this.question = question;
        this.answer = answer;
        this.possibleAnswers = possibleAnswers;
    }
}

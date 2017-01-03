package com.example.wolkje.aphasia;

import java.util.ArrayList;

/**
 * Created by Wolkje on 3/01/2017.
 */

public class QuestionMaker {
    private String question;
    private String answer;
    private ArrayList<String> possibleAnswers; //also contains answer

    public QuestionMaker(){


    }

    private ArrayList<Question> generateQuestion(String type){
        ArrayList<Question> questions;
        switch (type){
            case "type1":
                questions = generateType1Questions();
                break;
            case "type2":
                questions = generateType2Questions();
                break;
            case "type3":
                questions = generateType3Questions();
                break;
            default:
                questions = null;
                break;
        }
        return questions;
    }


    private ArrayList<Question> generateType1Questions() {
        ArrayList<Question> questions = new ArrayList<Question>();
        return questions;
    }

    private ArrayList<Question> generateType2Questions() {
        ArrayList<Question> questions = new ArrayList<Question>();
        return questions;
    }

    private ArrayList<Question> generateType3Questions() {
        ArrayList<Question> questions = new ArrayList<Question>();
        return questions;
    }
}

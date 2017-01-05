package com.example.wolkje.aphasia.model;

import android.content.Context;

import com.example.wolkje.aphasia.model.question.Question;
import com.example.wolkje.aphasia.model.question.Type1Question;
import com.example.wolkje.aphasia.model.question.Type2Question;
import com.example.wolkje.aphasia.model.question.Type3Question;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Wolkje on 3/01/2017 at 11:13 at 11:14.
 * Part of ${PACKAGE_NAME}.
 */

public class QuestionMaker  {

    private Context context;

    public QuestionMaker(Context context){
        this.context = context;

    }
    /*
    * Method to evoke when a new list question of specific type needs to be generated
    * */

    private ArrayList<Question> generateQuestionList(String type, int... a){
        ArrayList<Question> questions;
        //if a doesn't exist, value is set to 10
        int a1 = a.length > 0 ? a[0] : 10;
        switch (type){
            case "type1":
                questions = generateType1Questions(a1);
                break;
            case "type2":
                questions = generateType2Questions(a1);
                break;
            case "type3":
                questions = generateType3Questions(a1);
                break;
            default:
                questions = null;
                break;
        }
        return questions;
    }


    private ArrayList<Question> generateType1Questions(int a) {
        ArrayList<Question> questions = new ArrayList<>(a);

        String question;
        String answer;
        ArrayList<String> possibleAnswers;

        FileInputStream input;
        InputStreamReader inputReader;
        BufferedReader bufferedReader;

        for(int i  = 0; i < a; i++){
            try {

                /*Reading question from file*/
                input = context.openFileInput("Data/Type1/Question" + i + "/question.txt");
                inputReader = new InputStreamReader(input);
                bufferedReader = new BufferedReader(inputReader);
                question = bufferedReader.readLine() != null ? bufferedReader.readLine() : "Question not found.";

                /*Counting amount of possible answers*/
                File[] files = new File("Data/Type1/Question" + i).listFiles();
                int amountFiles = 0;
                for (File file : files) { //is safe way of counting amount of possible answers. files.lenght - 1 works too (for now)
                    String name = file.getName();
                    if(name.endsWith(".jpg")){
                        amountFiles++;
                    }
                }

                /*setting the correct answer*/
                answer = ("Data/Type1/Vraag" + i + "/answer0");

                /*adding bogus answers, randomly selected from the map*/
                possibleAnswers = new ArrayList<>(4);
                ArrayList<String> tempAnswers = new ArrayList<>(amountFiles);
                for (int j = 0; j < amountFiles; j++){
                    tempAnswers.add("Data/Type1/Question" + i + "/answer" + j);
                }
                addThreeRandomAnswers(tempAnswers);

                Question question1 = new Type1Question(question, answer, possibleAnswers);
                questions.add(question1);

            } catch (IOException ex){
                ex.printStackTrace();
            }
        }
        return questions;
    }

    private ArrayList<Question> generateType2Questions(int a) {
        ArrayList<Question> questions = new ArrayList<>(a);

        String question;
        String answer;
        ArrayList<String> possibleAnswers;

        FileInputStream input;
        InputStreamReader inputReader;
        BufferedReader bufferedReader;

        for(int i  = 0; i < a; i++){
            try {

                /*Reading question from file*/
                input = context.openFileInput("Data/Type2/Question" + i + "/question.txt");
                inputReader = new InputStreamReader(input);
                bufferedReader = new BufferedReader(inputReader);
                question = bufferedReader.readLine() != null ? bufferedReader.readLine() : "Question not found.";

                /*Counting amount of possible answers*/
                File[] files = new File("Data/Type2/Question" + i).listFiles();
                int amountFiles = 0;
                for (File file : files) { //is safe way of counting amount of possible answers. files.lenght - 1 works too (for now)
                    String name = file.getName();
                    if(name.endsWith(".jpg")){
                        amountFiles++;
                    }
                }

                /*setting the correct answer*/
                answer = ("Data/Type2/Vraag" + i + "/answer0");

                /*adding bogus answers, randomly selected from the map*/
                possibleAnswers = new ArrayList<>(4);
                ArrayList<String> tempAnswers = new ArrayList<>(amountFiles);
                for (int j = 0; j < amountFiles; j++){
                    tempAnswers.add("Data/Type2/Question" + i + "/answer" + j);
                }
                addThreeRandomAnswers(tempAnswers);

                Question question1 = new Type2Question(question, answer, possibleAnswers);
                questions.add(question1);

            } catch (IOException ex){
                ex.printStackTrace();
            }
        }
        return questions;
    }

    private ArrayList<Question> generateType3Questions(int a) {
        ArrayList<Question> questions = new ArrayList<>(a);

        String question;
        String answer;
        ArrayList<String> possibleAnswers;

        FileInputStream input;
        InputStreamReader inputReader;
        BufferedReader bufferedReader;

        for(int i  = 0; i < a; i++){
            try {

                /*Reading question from file*/
                input = context.openFileInput("Data/Type3/Question" + i + "/question.txt");
                inputReader = new InputStreamReader(input);
                bufferedReader = new BufferedReader(inputReader);
                question = bufferedReader.readLine() != null ? bufferedReader.readLine() : "Question not found.";

                /*Counting amount of possible answers*/
                File[] files = new File("Data/Type3/Question" + i).listFiles();
                int amountFiles = 0;
                for (File file : files) { //is safe way of counting amount of possible answers. files.lenght - 1 works too (for now)
                    String name = file.getName();
                    if(name.endsWith(".jpg")){
                        amountFiles++;
                    }
                }

                /*setting the correct answer*/
                answer = ("Data/Type3/Vraag" + i + "/answer0");

                /*adding bogus answers, randomly selected from the map*/
                possibleAnswers = new ArrayList<>(4);
                ArrayList<String> tempAnswers = new ArrayList<>(amountFiles);
                for (int j = 0; j < amountFiles; j++){
                    tempAnswers.add("Data/Type3/Question" + i + "/answer" + j);
                }
                addThreeRandomAnswers(tempAnswers);

                Question question1 = new Type3Question(question, answer, possibleAnswers);
                questions.add(question1);

            } catch (IOException ex){
                ex.printStackTrace();
            }
        }
        return questions;
    }


    private ArrayList<String> addThreeRandomAnswers(ArrayList<String> answers){
        ArrayList<String> clone = new ArrayList<>(answers);
        clone = (ArrayList<String>)clone.subList(1, clone.size());
        Collections.shuffle(clone);
        clone.add(0, answers.get(0));
        return clone;
    }


}




/*images zijn altijd strings
* kunnen niet meegegeven worden met intent --> image nooit laden, enkel in views
* imageposities in view zijn random voor de view, beslist door model
* naam gekozen image moet doorgegeven worden aan model, die controleert juistheid
* */
package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Login extends AppCompatActivity implements View.OnClickListener {

    String [] mcq1 = {"In multilevel inheritance, which is the most significant feature of OOP used?", "Code efficiency", "Code readability", "Flexibility", "Code reusability", "Code reusability"};
    String [] mcq2 = {"How many types of access specifiers are provided in OOP (C++)?", "1", "2", "3", "4", "3"};
    String [] mcq3 = {"Which among the following doesn’t come under OOP concept?", "Data Hiding", "Message Passing", "Platform Independent", "Data binding", "Platform Independent"};
    String [] mcq4 = {"Which header file is required in C++ to use OOP?","stdlib.h", "iostream.h", "stdio.h","Not needed", "Not needed"};
    String [] mcq5 = {"Which feature of OOP indicates code reusability?", "Abstraction", "Polymorphism", "Encapsulation", "Inheritance", "Inheritance"};
    String [] mcq6 = {"Which was the first purely object oriented programming language developed?", "kotlin", "SmallTalk", "Java", "C++", "SmallTalk"};
    String [] mcq7 = {"Which access specifier is usually used for data members of a class?", "Protected", "Private","Public", "Default", "Private"};
    String [] mcq8 = {"Which feature of OOP reduces the use of nested classes?", "Inheritance", "Binding", "Abstraction", "Encapsulation", "Inheritance"};
    String [] mcq9 = {"Which keyword among the following can be used to declare an array of objects in java?", "Allocate", "arr", "new", "create", "new"};
    String [] mcq10 = {"How to access data members of a class?", "Dot, arrow", "Dot Operator", "Arrow Operator", "Dot or arrow as required", "Dot or arrow as required"};

    Button a, b, c, d;
    TextView questioncount, question;

    //Populate it to generate Random mcqs
    String randomquestions = "";

    //popoulate to generate Random options
    String randomoptions = "";

    //Correct Answers

    ArrayList<String[]> allmcqs = new ArrayList<String[]>();

    //totalcount

    int totalcount = 0;
    int counter = 1;
    int totalcorrect = 0;
    DBHandler dbHandler;
    int QuizID = 0;
    String userNaam = "";
    ArrayList<String> resultCard = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHandler = new DBHandler(this);

        Bundle bundle = getIntent().getExtras();

        userNaam = bundle.getString("UserName");

        a = findViewById(R.id.option1);
        a.setOnClickListener(this);
        b = findViewById(R.id.option2);
        b.setOnClickListener(this);
        c = findViewById(R.id.option3);
        c.setOnClickListener(this);
        d = findViewById(R.id.option4);
        d.setOnClickListener(this);
        question = findViewById(R.id.question);
        questioncount = findViewById(R.id.questioncount);

        allmcqs.add(mcq1);
        allmcqs.add(mcq2);
        allmcqs.add(mcq3);
        allmcqs.add(mcq4);
        allmcqs.add(mcq5);
        allmcqs.add(mcq6);
        allmcqs.add(mcq7);
        allmcqs.add(mcq8);
        allmcqs.add(mcq9);
        allmcqs.add(mcq10);

        generaterandQuestions();
        generaterandOptions();
        char e = randomquestions.charAt(0);
        int f = Character.getNumericValue(e);
        String [] setmcq = allmcqs.get(f);
        question.setText(setmcq[0]);



        a.setText(setmcq[Character.getNumericValue(randomoptions.charAt(0))]);
        b.setText(setmcq[Character.getNumericValue(randomoptions.charAt(1))]);
        c.setText(setmcq[Character.getNumericValue(randomoptions.charAt(2))]);
        d.setText(setmcq[Character.getNumericValue(randomoptions.charAt(3))]);
    }


    public void generaterandQuestions() {
        Integer i = 0;
        Random random = new Random();
        while (i < 10 ) {
            Integer num = random.nextInt(10);
            if (!randomquestions.contains(num.toString())) {
                i++;
                randomquestions += num;
            }
        }
    }
    public void generaterandOptions() {
        Integer i = 0;
        Random random = new Random();
        while (i < 4 ) {
            Integer num = random.nextInt(4) + 1;
            if (!randomoptions.contains(num.toString())) {
                i++;
                randomoptions += num;
            }
        }
    }

    public void setMcqs(String naam) {
        if (counter < 11) {
            char nextindex = randomquestions.charAt(totalcount);
            int realindex = Character.getNumericValue(nextindex);
            String [] getvalue = allmcqs.get(realindex);
            String mcqvalue = getvalue[0];
            question.setText(mcqvalue);
            a.setText(getvalue[Character.getNumericValue(randomoptions.charAt(0))]);
            b.setText(getvalue[Character.getNumericValue(randomoptions.charAt(1))]);
            c.setText(getvalue[Character.getNumericValue(randomoptions.charAt(2))]);
            d.setText(getvalue[Character.getNumericValue(randomoptions.charAt(3))]);
        }
        else {
            QuizID = dbHandler.generateQuizID(naam);
            Intent intt = new Intent(Login.this, ResultScreen.class);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("resultCard", resultCard);
            bundle.putString("correctAns", String.valueOf(totalcorrect));
            intt.putExtras(bundle);
            startActivity(intt);
        }
    }

    public void checkCorrectness (String option, String value) {
        String [] mcq = {};
        String oldvalue = "";
        StringBuilder result = new StringBuilder(value + "\nSelected: " + option + "\nCorrect: ");
        String resultCase = "";
        //option ----> selected
        //value  ----> mcq
        //getid
        //correctOption ----> correct
        String correct = "";

        for (int i = 0; i < allmcqs.size(); i++) {
            mcq = allmcqs.get(i);
            oldvalue = mcq[0];
            String correctOption = mcq[mcq.length-1];
            if (oldvalue.equals(value) ) {
                correct = correctOption;
                result.append(correctOption);
                if (correctOption.equals(option)) {
                    resultCase = "true";
                    totalcorrect++;
                }
                else {
                    resultCase = "true";
                }
            }
        }
        Quiz data = new Quiz(QuizID, value, option, correct, resultCase);
        dbHandler.insertResut(data);
        resultCard.add(result.toString());
    }

    @Override
    public void onClick(View view) {
        totalcount++;
        counter++;
        String text = String.valueOf(counter);
        Button newValue;
        TextView nextmcq;
        switch (view.getId()) {
            case R.id.option1:
                newValue = findViewById(R.id.option1);
                nextmcq = findViewById(R.id.question);
                questioncount.setText(text);
                checkCorrectness(newValue.getText().toString(), nextmcq.getText().toString());
                break;
            case R.id.option2:
                newValue = findViewById(R.id.option2);
                nextmcq = findViewById(R.id.question);
                questioncount.setText(text);
                checkCorrectness(newValue.getText().toString(), nextmcq.getText().toString());
                break;
            case R.id.option3:
                newValue = findViewById(R.id.option3);
                nextmcq = findViewById(R.id.question);
                questioncount.setText(text);
                checkCorrectness(newValue.getText().toString(), nextmcq.getText().toString());
                break;
            case R.id.option4:
                newValue = findViewById(R.id.option4);
                nextmcq = findViewById(R.id.question);
                questioncount.setText(text);
                checkCorrectness(newValue.getText().toString(), nextmcq.getText().toString());
                break;
        }
        setMcqs(userNaam);
    }
}
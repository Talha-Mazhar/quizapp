package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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
    ArrayList<Integer> randomquestions = new ArrayList<Integer>();

    //popoulate to generate Random options
    ArrayList<Integer> randomoptions = new ArrayList<Integer>();

    //Correct Answers

    ArrayList<String[]> allmcqs = new ArrayList<String[]>();

    //totalcount

    int totalcount = 0;

    int totalcorrect = 0;

    String [] selectedData = {};

    ArrayList<String[]> resultCard = new ArrayList<String[]>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        String [] setmcq = allmcqs.get(randomquestions.get(0));

        question.setText(setmcq[0]);

        a.setText(setmcq[1]);
        b.setText(setmcq[2]);
        c.setText(setmcq[3]);
        d.setText(setmcq[4]);
    }


    public void generaterandQuestions() {
        int i = 0;
        Random random = new Random();
        while (i < 10 ) {
            int num = random.nextInt(9);
            if (!randomquestions.contains(num)) {
                i++;
                randomquestions.add(num);
            }
        }
    }
    public void generaterandOptions() {
        int i = 0;
        Random random = new Random();
        while (i < 4 ) {
            int num = random.nextInt(4) + 1;
            if (!randomoptions.contains(num)) {
                i++;
                randomoptions.add(num);
            }
        }
    }

    public void setMcqs() {
        int getindex = randomquestions.get(totalcount);
        String [] getvalue = allmcqs.get(getindex);
        String mcqvalue = getvalue[0];
        question.setText(mcqvalue);
        a.setText(getvalue[1]);
        b.setText(getvalue[2]);
        c.setText(getvalue[3]);
        d.setText(getvalue[4]);
    }

    public void checkCorrectness (String value, String option) {
        selectedData[0] = value;
        selectedData[1] = option;
        String [] mcq = {};
        String oldvalue = "";
        for (int i = 0; i <= allmcqs.size(); i++) {
            mcq = allmcqs.get(i);
            oldvalue = mcq[0];
            selectedData[1] = oldvalue;
            selectedData[3] = option;
            allmcqs.add(selectedData);
            String correctOption = mcq[mcq.length-1];
            if (oldvalue.equals(value) && correctOption.equals(option)) {
                totalcount++;
            }
        }
    }

    @Override
    public void onClick(View view) {
        totalcount++;
        String text = String.valueOf(totalcount);
        Button newValue;
        TextView nextmcq;
        switch (view.getId()) {
            case R.id.option1:
                newValue = findViewById(R.id.option1);
                nextmcq = findViewById(R.id.question);
                questioncount.setText(text);
                checkCorrectness(newValue.getText().toString(), nextmcq.getText().toString());
                setMcqs();
                break;
            case R.id.option2:
                newValue = findViewById(R.id.option2);
                nextmcq = findViewById(R.id.question);
                questioncount.setText(text);
                checkCorrectness(newValue.getText().toString(), nextmcq.getText().toString());
                setMcqs();
                break;
            case R.id.option3:
                newValue = findViewById(R.id.option3);
                nextmcq = findViewById(R.id.question);
                questioncount.setText(text);
                checkCorrectness(newValue.getText().toString(), nextmcq.getText().toString());
                setMcqs();
                break;
            case R.id.option4:
                newValue = findViewById(R.id.option4);
                nextmcq = findViewById(R.id.question);
                questioncount.setText(text);
                checkCorrectness(newValue.getText().toString(), nextmcq.getText().toString());
                setMcqs();
                break;
        }
    }
}
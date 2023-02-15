package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Result extends AppCompatActivity {

    ArrayList<Quiz> data = new ArrayList<Quiz>();
    DBHandler dbHandler;
    ListView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        dbHandler = new DBHandler(this);
        result = findViewById(R.id.result);
        Bundle bundle = getIntent().getExtras();

        int id = bundle.getInt("quizid");
        Log.d("id", Integer.toString(id));
        data = dbHandler.getQuizesData(id);


        ArrayAdapter<Quiz> adpt = new ArrayAdapter<Quiz>(this, android.R.layout.simple_list_item_1, data);
        result.setAdapter(adpt);
    }
}
package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class ResultScreen extends AppCompatActivity implements Serializable {
    ListView listView;
    TextView textView, percentage;
    Button share, backbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);


        listView = findViewById(R.id.list_view);
        textView = findViewById(R.id.textView);
        percentage = findViewById(R.id.percentage);
        share = findViewById(R.id.share);
        Bundle bundle = getIntent().getExtras();
        String correct = bundle.getString("correctAns");

        ArrayList<String> data = new ArrayList<String>();
        data = bundle.getStringArrayList("resultCard");

        ArrayAdapter<String> adpt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adpt);
        int ser = Integer.parseInt(correct);
        float totalpercentage = (100 * ser) / 10;
        String per = "Percentage: " + Float.toString(totalpercentage);
        percentage.setText(per);
        correct = "Total Correct: " + correct;
        textView.setText(correct);

        String send = correct + "\n" + per;
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, send);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }
}
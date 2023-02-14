package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Button checkresultbtn = (Button) findViewById(R.id.checkresult);
        Button newquizbtn = (Button) findViewById(R.id.takequiz);
        Button backbtn = (Button) findViewById(R.id.back);

        TextView showuser = (TextView) findViewById(R.id.user);

        checkresultbtn.setOnClickListener(this);
        newquizbtn.setOnClickListener(this);
        backbtn.setOnClickListener(this);


        //take data from intent and show username

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String userName = bundle.getString("UserName");
            userName = "Welcome " + userName;
            showuser.setText(userName);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.checkresult:
                break;
            case R.id.takequiz:
                Intent intt = new Intent(Profile.this, Login.class);
                startActivity(intt);
                break;
            case R.id.back:
                System.exit(0);
                break;
        }
    }
}
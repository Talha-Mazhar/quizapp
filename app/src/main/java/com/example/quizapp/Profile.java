package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends AppCompatActivity implements View.OnClickListener {

    Button checkresult, newquiz, back;
    TextView showuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        checkresult.findViewById(R.id.checkresult);
        checkresult.setOnClickListener(this);
        newquiz.findViewById(R.id.takequiz);
        newquiz.setOnClickListener(this);
        back.findViewById(R.id.back);
        back.setOnClickListener(this);

        showuser.findViewById(R.id.user);

        //take data from intent and show username

        Bundle bundle = getIntent().getExtras();
        String userName = bundle.getString("user");

        showuser.setText(userName);
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
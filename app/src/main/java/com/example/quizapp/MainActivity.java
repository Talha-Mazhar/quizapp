package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button login;
    EditText userName;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);
        login.setOnClickListener(this);
        userName = findViewById(R.id.userName);

        dbHandler = new DBHandler(MainActivity.this);
    }

    @Override
    public void onClick(View view) {
        String naam = userName.getText().toString();
        if (naam.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
            return;
        }
        ArrayList<Users> getuserData = new ArrayList<Users>();
        getuserData = dbHandler.getUserData(naam);

        for (int i = 0; i <= getuserData.size(); i++) {
            if (!getuserData.get(i).getUsername().equals(naam)) {
                dbHandler.insertRecord(naam);
            }
        }

        switch (view.getId()) {
            case R.id.login:
                Intent intt = new Intent(MainActivity.this, Profile.class);
//                Bundle bundle = new Bundle();
//                bundle.putStringArrayList("resultCard", resultCard);
//                bundle.putString("correctAns", String.valueOf(totalcorrect));
//                intt.putExtras(bundle);

                startActivity(intt);
                break;
        }
    }
}
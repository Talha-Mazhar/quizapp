package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button login;
    EditText userName;
    DBHandler dbHandler;
    SQLiteDatabase database; //add this line
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);
        userName = findViewById(R.id.userName);
        dbHandler = new DBHandler(this);
        database = dbHandler.getWritableDatabase();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String naam = userName.getText().toString();

                if (naam.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter Username..", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    ArrayList<Users> getuserData = new ArrayList<Users>();
                    getuserData = dbHandler.getUserData(naam);

                    if (!getuserData.isEmpty()){
                        for (int i = 0; i < getuserData.size(); i++) {
                            if (!getuserData.get(i).getUsername().equals(naam)) {
                                dbHandler.insertRecord(naam);
                            }
                        }
                        Intent intt = new Intent(MainActivity.this, Profile.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("UserName", naam);
                        intt.putExtras(bundle);
                        startActivity(intt);
                    }
                    else {
                        dbHandler.insertRecord(naam);
                        Intent intt = new Intent(MainActivity.this, Profile.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("UserName", naam);
                        intt.putExtras(bundle);
                        startActivity(intt);
                    }
                }
            }
        });
    }
}

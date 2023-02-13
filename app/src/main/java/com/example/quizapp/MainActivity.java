package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button login;

    String username = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);
        login.setOnClickListener(this);
    }
    public void checkCredientials(String naam) {
        int i = 0;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                Intent intt = new Intent(MainActivity.this, Login.class);
//                Bundle bundle = new Bundle();
//                bundle.putStringArrayList("resultCard", resultCard);
//                bundle.putString("correctAns", String.valueOf(totalcorrect));
//                intt.putExtras(bundle);
                String name = "";
                name = username;
                checkCredientials(name);
                startActivity(intt);
                break;
        }
    }
}
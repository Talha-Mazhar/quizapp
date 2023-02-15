package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class QuizesList extends AppCompatActivity {

    String userNaam = "";
    DBHandler dbHandler;

    ListView listing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizes_list);

        listing = findViewById(R.id.listingItems);
        dbHandler = new DBHandler(this);

        Bundle bundle = getIntent().getExtras();

        userNaam = bundle.getString("naam");

        int userID = dbHandler.getUserId(userNaam);

        ArrayList<Integer> ids = new ArrayList<Integer>();

        ids = dbHandler.getuserQuizesId(userID);

        ArrayAdapter<Integer> adpt = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, ids);
        listing.setAdapter(adpt);
    }
}
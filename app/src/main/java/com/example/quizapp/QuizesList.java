package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class QuizesList extends AppCompatActivity {

    String userNaam = "";
    DBHandler dbHandler;

    ListView listing;
    ArrayList<Integer> ids;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizes_list);

        listing = findViewById(R.id.listingItems);
        dbHandler = new DBHandler(this);

        Bundle bundle = getIntent().getExtras();

        userNaam = bundle.getString("naam");

        int userID = dbHandler.getUserId(userNaam);

        ids = new ArrayList<Integer>();

        ids = dbHandler.getuserQuizesId(userID);

        ArrayAdapter<Integer> adpt = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, ids);
        listing.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intt = new Intent(QuizesList.this, Result.class);
                Bundle bundle = new Bundle();
                int id = ids.get(i);
                bundle.putInt("quizid", id);
                intt.putExtras(bundle);
                startActivity(intt);
            }
        });
        listing.setAdapter(adpt);
    }
}
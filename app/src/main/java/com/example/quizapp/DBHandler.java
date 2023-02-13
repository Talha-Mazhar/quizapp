package com.example.quizapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "QuizApp.db";
    private static final String TABLE_NAME = "Result";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_Mcq = "Mcq";
    private static final String COLUMN_Selected = "Selected";
    private static final String COLUMN_Correct = "Correct";
    private static final String COLUMN_isCorrect = "isCorrect";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

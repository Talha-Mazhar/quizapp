package com.example.quizapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "QuizApp.db";
    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ "users" +" (userid INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT)");
        db.execSQL("create table "+ "quizes" +" (createid INTEGER PRIMARY KEY AUTOINCREMENT,  user INTEGER, FOREIGN KEY(user) REFERENCES users(userid))");
        db.execSQL("create table "+ "results" +" (quizid INTEGER, mcq TEXT, selected TEXT, correct TEXT, isCorrect TEXT, FOREIGN KEY(quizid) REFERENCES quizes(createid))");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + "users");
        db.execSQL("DROP TABLE IF EXISTS " + "quizes");
        db.execSQL("DROP TABLE IF EXISTS " + "results");
        onCreate(db);
    }

    public void insertRecord(String naam) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("username", naam);

        db.insert("users", null, values);
        db.close();
    }

//    public List<String> selectAllresults() {
//        List<String> totalresult = new ArrayList<>();
//
//        String sql = "select * from " + "TABLE_NAME" +" order by id DESC"  ;
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(sql, null);
//
//          if (cursor.moveToFirst()) {
//            do {
//                totalresult.add(new StudentModel(cursor.getString(1),
//                        cursor.getInt(2),
//                        cursor.getInt(3) == 1 ? true : false));
//            } while (cursor.moveToNext());
//
//
//        while(cursor.moveToNext()) {
//            String SA=cursor.getString(1);
//            String CA=cursor.getString(2);
//            // int isc ;
//            totalresult.add(new quizResult(SA, CA, cursor.getInt(3) == 1 ? true : false));
//        }
//
//        cursor.close();
//        db.close();
//
//       return totalresult;
//    }

    public ArrayList<Users> getUserData(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users",null);
        ArrayList<Users> users_username = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                users_username.add(new Users(cursor.getInt(0),
                        cursor.getString(1)));
            } while (cursor.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursor.close();
        return users_username;
    }


    public ArrayList<Quiz> getQuizesData(int userid) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT createid FROM quizes WHERE user=" + userid,null);
        ArrayList<Quiz> userQuizes = new ArrayList<>();

        ArrayList<Integer> quizids = new ArrayList<Integer>();

        if (cursor.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                quizids.add(cursor.getInt(0));
            } while (cursor.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursor.close();

        Cursor cursorQuizes = db.rawQuery("SELECT createid FROM quizes WHERE user=" + userid,null);

        return userQuizes;
    }

}

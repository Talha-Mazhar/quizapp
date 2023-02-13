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
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                //               + COLUMN_datetime + " datetime,"
                + COLUMN_Mcq + " TEXT,"
                + COLUMN_Selected + " TEXT,"
                + COLUMN_Correct + " TEXT,"
                + COLUMN_isCorrect + " BOOL"
                + ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }

    public void insertRecord() {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();


        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<String> selectAllresults() {
        List<String> totalresult = new ArrayList<>();

        String sql = "select * from " + TABLE_NAME +" order by id DESC"  ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

/*        if (cursor.moveToFirst()) {
            do {
                totalresult.add(new StudentModel(cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getInt(3) == 1 ? true : false));
            } while (cursor.moveToNext());
        }*/

//        while(cursor.moveToNext()) {
//            String SA=cursor.getString(1);
//            String CA=cursor.getString(2);
//            // int isc ;
//            totalresult.add(new quizResult(SA, CA, cursor.getInt(3) == 1 ? true : false));
//        }

        cursor.close();
        db.close();

        return totalresult;
    }
}

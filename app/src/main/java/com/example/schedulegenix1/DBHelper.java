package com.example.schedulegenix1;


import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Piyumi.db";
    public static final String CARD_INFORMATION_TABLE_NAME = "card_information";
    public static final String CARD_INFORMATION_COLUMN_ID = "id";
    public static final String CARD_INFORMATION_COLUMN_NAME = "name";
    public static final String CARD_INFORMATION_COLUMN_TYPE = "type";
    public static final String CARD_INFORMATION_COLUMN_NUMBER = "number";
    public static final String CARD_INFORMATION_COLUMN_DATE = "date";
    private HashMap hp;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table card_information " +
                        "(id integer primary key, name text,type text, number text, date text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS card_information");
        onCreate(db);
    }

    public boolean insertinformation(String name, String type, String number, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("type", type);
        contentValues.put("number", number);
        contentValues.put("date", date);
        db.insert("card_information", null, contentValues);
        return true;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from card_information where id=" + id + "", null);
        return res;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, CARD_INFORMATION_TABLE_NAME);
        return numRows;
    }

    public boolean updateinformation(Integer id, String name, String type, String number, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("type", type);
        contentValues.put("number", number);
        contentValues.put("date", date);
        db.update("card_information", contentValues, "id = ? ", new String[]{Integer.toString(id)});
        return true;
    }

    public Integer deleteInformation(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("card_information",
                "id = ? ",
                new String[]{Integer.toString(id)});
    }

    public ArrayList<String> getAllInformation() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from card_information", null);
        res.moveToFirst();

        while (res.isAfterLast() == false) {
            array_list.add(res.getString(res.getColumnIndex(CARD_INFORMATION_COLUMN_NAME)));
            res.moveToNext();
        }
        return array_list;
    }

}


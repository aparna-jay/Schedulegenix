package com.example.schedulegenix1;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Aparna.db";
    public static final String SCHEDULES_TABLE_NAME = "schedules";
    public static final String SCHEDULES_COLUMN_ID = "id";
    public static final String SCHEDULES_COLUMN_TITLE = "title";
    public static final String SCHEDULES_COLUMN_DATE = "date";
    public static final String SCHEDULES_COLUMN_STARTTIME = "starttime";
    public static final String SCHEDULES_COLUMN_ENDTIME = "endtime";
    public static final String SCHEDULES_COLUMN_VENUE = "venue";
    private HashMap hp;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table schedules " +
                        "(id integer primary key, title text,date text,starttime text, endtime text,venue text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS schedules");
        onCreate(db);
    }

    public boolean insertSchedule (String title, String date, String starttime, String endtime,String venue) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("date", date);
        contentValues.put("starttime", starttime);
        contentValues.put("endtime", endtime);
        contentValues.put("venue", venue);
        db.insert("schedules", null, contentValues);
        return true;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from schedules where id="+id+"", null );
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, SCHEDULES_TABLE_NAME);
        return numRows;
    }

    public boolean updateSchedule (Integer id, String title, String date, String starttime, String endtime,String venue) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("date", date);
        contentValues.put("starttime", starttime);
        contentValues.put("endtime", endtime);
        contentValues.put("venue", venue);
        db.update("schedules", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public Integer deleteSchedule (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("schedules",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public ArrayList<String> getAllSchedules() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from schedules", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(SCHEDULES_COLUMN_TITLE)));
            res.moveToNext();
        }
        return array_list;
    }
}

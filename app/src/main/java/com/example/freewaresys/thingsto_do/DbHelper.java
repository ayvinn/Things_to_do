package com.example.freewaresys.thingsto_do;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {


    private static final String DB_NAME = "Db_todos";
    private static final int DB_VER = 1;
    public static final String DB_TABLE="todo";

    public static final String TODO_STATUS="status";
    public static final String TODO_TITLE="title";
    public static final String TODO_NOTES="notes";
    public static final String TODO_DATE="date";




    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = String.format("CREATE TABLE %s (ID INTEGER PRIMARY KEY AUTOINCREMENT,%s TEXT, %s TEXT NOT NULL,%s TEXT,%s TEXT)",
                DB_TABLE,
                TODO_STATUS,
                TODO_TITLE,
                TODO_NOTES,
                TODO_DATE);
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = String.format("DELETE TABLE IF EXISTS %s",DB_TABLE);
        db.execSQL(query);
        onCreate(db);

    }


    public void insertNewTodo(String title_,String notes_,String date_)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TODO_TITLE,title_);
        values.put(TODO_NOTES,notes_);
        values.put(TODO_STATUS,"false");
        values.put(TODO_DATE,date_);
        db.insertWithOnConflict(DB_TABLE,null,values,SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
    }


    public void deleteTodo(String todo)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DB_TABLE,TODO_TITLE + " = ?", new String[]{todo});
        db.close();
    }


    public ArrayList<String> getTodoList()
    {
        ArrayList<String> todoList = new ArrayList<>();

        /*todoList.add("item1");
        todoList.add("item2");
        todoList.add("itemk");*/


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(DB_TABLE, new String[]{TODO_TITLE},null,null,null,null,null);
        while (cursor.moveToNext())
        {
            int index = cursor.getColumnIndex(TODO_TITLE);
            todoList.add(cursor.getString(index));
        }
        cursor.close();
        db.close();
        return todoList;

    }













}

package com.hci.pandemic.pandemic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by andrewparrish on 11/28/14.
 */
public class DBHelper extends SQLiteOpenHelper {
    //TODO: Declare table name, column, etc

    public static final String TABLE_USERS = "users";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "user_name";
    public static final String COLUMN_SCORE = "score";
    public static final String COLUMN_DISEASE = "disease_name";

    private static final String DATABASE_NAME = "pandemic.db";
    private static final int DATABASE_VERSION = 1;

    //Database creation SQL statement
    private static final String DATABASE_CREATE = "create table " +
            TABLE_USERS + "(" + COLUMN_ID + " integer primary key autoincrement, " +
            COLUMN_NAME + " text not null, " + COLUMN_SCORE + " integer, " +
            COLUMN_DISEASE + " text not null" + ");";

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    public long getUserCount(){
        SQLiteDatabase db = this.getWritableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, TABLE_USERS);
        return count;
    }

    public boolean userExists(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;

        cursor = db.query(TABLE_USERS, new String[] {COLUMN_ID, COLUMN_NAME, COLUMN_DISEASE,
            COLUMN_SCORE}, COLUMN_NAME + "=?", new String[] {name}, null, null, null, null);
        if (cursor.moveToFirst()){
            return true;
        }
        return false;
    }

    public void addUser(String name, String disease){
        if (userExists(name)){
            return;
        }

        Random random = new Random();
        int score = random.nextInt(100 - 10) + 10;

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_ID, getUserCount() + 1);
        values.put(COLUMN_SCORE, score);
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_DISEASE, disease);

        db.insert(TABLE_USERS, null, values);
    }

    public List<User> getAllUsers(){
        List<User> userList = new ArrayList<User>();

        String query = "SELECT * FROM "+ TABLE_USERS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                int score = cursor.getInt(2);
                String disease = cursor.getString(3);
                User user = new User(id, name, disease, null);
                user.setScore(score);
                userList.add(user);
            }while(cursor.moveToNext());
        }

        return userList;
    }

}

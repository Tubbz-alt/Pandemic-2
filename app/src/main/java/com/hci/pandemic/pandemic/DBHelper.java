package com.hci.pandemic.pandemic;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by andrewparrish on 11/28/14.
 */
public class DBHelper extends SQLiteOpenHelper {
    //TODO: Declare table name, column, etc

    public static final String TABLE_USERS = "users";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "user_name";

    private static final String DATABASE_NAME = "pandemic.db";
    private static final int DATABASE_VERSION = 1;

    //Database creation SQL statement
    private static final String DATABASE_CREATE = "create table " +
            TABLE_USERS + "(" + COLUMN_ID + " integer primary key autoincrement, " +
            COLUMN_NAME + " text not null);";

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

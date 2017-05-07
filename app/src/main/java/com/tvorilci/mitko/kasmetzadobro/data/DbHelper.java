package com.tvorilci.mitko.kasmetzadobro.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "LittleLucks.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = " INTEGER";
    private static final String COMMA = ",";

    private static final String NOT_NULL = " NOT NULL";
    private static final String PRIMARY = " PRIMARY KEY AUTOINCREMENT";

    private static final String CREATE_ENTRIES_TABLE =
            "CREATE TABLE " + DatabaseContract.LITTLE_LUCKS_TABLE_NAME + "(" +
                    DatabaseContract._ID + INT_TYPE + PRIMARY + COMMA +
                    DatabaseContract.LITTLE_LUCKS_GOOD_THOUGHT + TEXT_TYPE + NOT_NULL + COMMA +
                    DatabaseContract.LITTLE_LUCKS_GOOD_DEED + TEXT_TYPE + NOT_NULL + COMMA +
                    DatabaseContract.LITTLE_LUCKS_TIMES_SHOWN + INT_TYPE + NOT_NULL + COMMA +
            ")";

    private static final String CREATE_PARAMETERS_TABLE =
            "CREATE TABLE " + DatabaseContract.PARAMETERS_TABLE_NAME + "(" +
                    DatabaseContract._ID + INT_TYPE + PRIMARY + COMMA +
                    DatabaseContract.PARAMETERS_NAME + TEXT_TYPE + NOT_NULL + COMMA +
                    DatabaseContract.PARAMETERS_VALUE + TEXT_TYPE + NOT_NULL + COMMA +
            ")";


    private static final String CREATE_ALARMS_TABLE =
            "CREATE TABLE " + DatabaseContract.ALARMS_TABLE_NAME + "(" +
                    DatabaseContract._ID + INT_TYPE + PRIMARY + COMMA +
                    DatabaseContract.ALARMS_TIME + INT_TYPE + NOT_NULL + COMMA +
                    DatabaseContract.ALARMS_ACTIVE + INT_TYPE + NOT_NULL + COMMA +
                    DatabaseContract.ALARMS_INTUITIVE + INT_TYPE + NOT_NULL + COMMA +
            ")";

    public DbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //TODO: create entries sql
        db.execSQL(CREATE_ENTRIES_TABLE);
        db.execSQL(CREATE_PARAMETERS_TABLE);
        db.execSQL(CREATE_ALARMS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //left empty
    }
}

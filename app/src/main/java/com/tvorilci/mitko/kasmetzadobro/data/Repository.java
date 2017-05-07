package com.tvorilci.mitko.kasmetzadobro.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mimi on 3/2/17.
 */
public class Repository {
    private static Repository INSTANCE;
    private DbHelper dbHelper;

    public Repository(Context context) {
        dbHelper = new DbHelper(context);
    }

    public static Repository getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new Repository(context);
        }

        return INSTANCE;
    }

    public List<LittleLuck> getLucks(){
        List<LittleLuck> entries = new ArrayList<LittleLuck>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String [] selectColumns = {
                DatabaseContract._ID,
                DatabaseContract.LITTLE_LUCKS_GOOD_THOUGHT,
                DatabaseContract.LITTLE_LUCKS_GOOD_DEED
        };

        Cursor cursor = db.query(DatabaseContract.LITTLE_LUCKS_TABLE_NAME, selectColumns, null, null,
                null, null, null);

        return entries;
    }

    public LittleLuck getRandomLuck() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String randomLuckQuery = String.format(
                "SELECT * FROM %1$s WHERE %2$s IN (SELECT %2$s FROM %1$s ORDER BY RANDOM() LIMIT %3$s)",
                DatabaseContract.LITTLE_LUCKS_TABLE_NAME, DatabaseContract._ID, "1");

        Cursor cursor = db.rawQuery(randomLuckQuery, new String[]);

        String goodThought = cursor.getString(cursor.getColumnIndex(DatabaseContract.LITTLE_LUCKS_GOOD_THOUGHT));
        String goodDeed = cursor.getString(cursor.getColumnIndex(DatabaseContract.LITTLE_LUCKS_GOOD_DEED));

        LittleLuck selectedLuck = new LittleLuck(goodThought, goodDeed);

        if (cursor != null){
            cursor.close();
        }

        db.close();

        return selectedLuck;
    }

}

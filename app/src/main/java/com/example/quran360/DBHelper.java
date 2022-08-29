package com.example.quran360;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;

    private final Context context;
    public DBHelper(Context context) {
        super(context,  params.DB_NAME , null, params.DB_VERSION);
        this. context  = context;
    }


}

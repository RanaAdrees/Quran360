package com.example.quran360;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DBHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;

    private final Context context;
    public DBHelper(Context context) {
        super(context,  params.DB_NAME , null, params.DB_VERSION);
        this. context  = context;
    }

    public void createDB() throws IOException {

        this.getReadableDatabase();
        Log.i("Readable DB Ends","end");

        try {
            copyDB();
            Log.i("copy db ends","end");

        } catch (IOException e) {

            throw new Error("Error copying database");
        }
    }

    public  boolean checkDB(){

        SQLiteDatabase checkDB = null;

        try{
            String path = params.DB_PATH + params.DB_NAME;
            Log.i("myPath",path);
            checkDB = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);

            Log.i("myPath ",path);
            if (checkDB!=null)
            {
                Cursor c= checkDB.rawQuery("SELECT * FROM tayah", null);

                if (c.moveToFirst()) {
                    do {

                        Log.i("Tayah ......",String.valueOf(c.getInt(0)));

                    } while (c.moveToNext());

                }
            }
            else
            {
                return false;
            }

        }catch(SQLiteException e){
            e.printStackTrace();
        }

        if(checkDB != null){

            checkDB.close();

        }
        return checkDB != null ? true : false;
    }

    public void copyDB() throws IOException{
        try {
            Log.i("inside copyDB..","start");

            InputStream ip =  context.getAssets().open(params.DB_NAME);
            //InputStream ip =  context.getAssets().open(DB_NAME+".db");
            Log.i("Input Stream....",ip+"");
            String op=  params.DB_PATH  +  params.DB_NAME ;
            OutputStream output = new FileOutputStream( op);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = ip.read(buffer))>0){
                output.write(buffer, 0, length);
                Log.i("Content.... ",length+"");
            }
            output.flush();
            output.close();
            ip.close();
        }
        catch (IOException e) {
            Log.v("error", e.toString());
        }
    }

}

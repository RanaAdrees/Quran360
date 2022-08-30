package com.example.quran360;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button SurahActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SurahActivity=findViewById(R.id.SurahActivity);

        DBHelper dbhelper=new DBHelper(this);

        try {
            dbhelper.createDB();
        } catch (IOException ioe) {

            throw new Error("Database not created....");
        }

        try {
            dbhelper.openDB();

        }catch(SQLException sqle){

            throw sqle;
        }

        dbhelper.checkDB();

        SurahActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SurahList.class);

                startActivity(intent);
            }
        });





    }
}
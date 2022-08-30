package com.example.quran360;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AyahList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayah_list);

        Intent intent=getIntent();
        int index=Integer.valueOf(intent.getStringExtra("SurahNo"));




        DBHelper dbhelper=new DBHelper(this);
        ArrayList<String> AANList;
        AANList=dbhelper.displayAyah(3,index+1);

        ArrayList<String> ATNList;
        ATNList=dbhelper.displayAyah(4,index+1);

        ListView ayahList=findViewById(R.id.ayahList);

        CustomArrayAdapterAyah customArrayAdapter=new CustomArrayAdapterAyah(this,AANList,ATNList);

        ayahList.setAdapter(customArrayAdapter);
    }
}
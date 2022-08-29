package com.example.quran360;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SurahList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_list);

        DBHelper dbhelper=new DBHelper(this);
        List<String> SANList=new ArrayList<>();
        SANList=dbhelper.displaySurahName("SurahNameU");

        List<String> SENList=new ArrayList<>();
        SENList=dbhelper.displaySurahName("SurahNameE");
        ListView surahList=findViewById(R.id.surahList);

        CustomArrayAdapterSurah customArrayAdapter=new CustomArrayAdapterSurah(this,SANList,SENList);

        surahList.setAdapter(customArrayAdapter);
    }
}
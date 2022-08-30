package com.example.quran360;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
        ArrayList<String> SANList;
        SANList=dbhelper.displaySurahName("SurahNameU");

        ArrayList<String> SENList;
        SENList=dbhelper.displaySurahName("SurahNameE");

        ListView surahList=findViewById(R.id.surahList);

        Log.i("Length of SAN:",SANList.get(6));
        Log.i("Length of SEN:",SENList.get(6));
        CustomArrayAdapterSurah customArrayAdapter=new CustomArrayAdapterSurah(this,SANList,SENList);

        surahList.setAdapter(customArrayAdapter);


        surahList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Log.i("Clicked on list:",String.valueOf(i));
                Intent intent=new Intent(SurahList.this,AyahList.class);
                intent.putExtra("SurahNo", String.valueOf(i));
                startActivity(intent);
            }
        });
    }
}
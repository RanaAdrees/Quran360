package com.example.quran360;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayAdapterSurah extends ArrayAdapter {
    Activity context;
    ArrayList<String> surahA;
    ArrayList<String> surahE;


    public CustomArrayAdapterSurah(Activity context, ArrayList<String> surahA, ArrayList<String> surahE) {

        super(context, 0, surahA);
        this.context=context;
        this.surahA=surahA;
        this.surahE=surahE;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View singleEntityView=inflater.inflate(
                R.layout.activity_custom_surah_view, null,true);

        TextView surahArabic=singleEntityView.findViewById(R.id.surahA);

        TextView surahEng=singleEntityView.findViewById(R.id.surahE);

        Log.i("Position value A:",surahA.get(position));
        Log.i("Position value E:",surahE.get(position));
        surahArabic.setText(surahA.get(position));
        surahEng.setText(surahE.get(position));
        return singleEntityView;
    }

}
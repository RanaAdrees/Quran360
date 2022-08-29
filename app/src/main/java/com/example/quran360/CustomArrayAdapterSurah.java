package com.example.quran360;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomArrayAdapterSurah extends ArrayAdapter {
    Activity context;
    String surahA[];
    String surahE[];


    public CustomArrayAdapterSurah(Activity context, String surahA[], String surahE[]) {
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

        surahArabic.setText(surahA[position]);
        surahEng.setText(surahE[position]);
        return singleEntityView;
    }

}
package com.example.quran360;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomArrayAdapterAyah extends ArrayAdapter {
    Activity context;
    String ayahArabicArr[];
    String ayahTransArr[];


    public CustomArrayAdapterAyah(Activity context, String ayahArabicArr[], String ayahTransArr[]) {
        super(context, 0, ayahArabicArr);
        this.context=context;
        this.ayahArabicArr=ayahArabicArr;
        this.ayahTransArr=ayahTransArr;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View singleEntityView=inflater.inflate(
                R.layout.activity_custom_ayah_view, null,true);

        TextView ayahArabic=singleEntityView.findViewById(R.id.ayahArabic);

        TextView ayahTrans=singleEntityView.findViewById(R.id.ayahTrans);

        ayahArabic.setText(ayahArabicArr[position]);
        ayahTrans.setText(ayahTransArr[position]);
        return singleEntityView;
    }

}

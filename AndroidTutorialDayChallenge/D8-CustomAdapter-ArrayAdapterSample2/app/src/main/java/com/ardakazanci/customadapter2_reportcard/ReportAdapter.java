package com.ardakazanci.customadapter2_reportcard;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ReportAdapter extends ArrayAdapter<ReportModel> {


    public ReportAdapter(Activity activity, List<ReportModel> reportModels) {

        super(activity, 0, reportModels);

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        ReportModel ogrenciBilgisi = getItem(position); //  İlgili öğrenci bilgisinin pozisyonunu veriyor.

        if (convertView == null) { // Hurda Listview öğesi oluşturuyoruz. Her öğe devir dayım yapılacak.

            view = LayoutInflater.from(getContext()).inflate(R.layout.list_style, parent, false);


        }

        TextView studentLesson = view.findViewById(R.id.textview_ders);
        studentLesson.setText(ogrenciBilgisi.getStudentLesson());
        TextView studenName = view.findViewById(R.id.textview_ogrenci);
        studenName.setText(ogrenciBilgisi.getStudentName());
        TextView studentNote = view.findViewById(R.id.textview_not);
        studentNote.setText(String.valueOf(ogrenciBilgisi.getStudentNote()));


        return view;


    }
}

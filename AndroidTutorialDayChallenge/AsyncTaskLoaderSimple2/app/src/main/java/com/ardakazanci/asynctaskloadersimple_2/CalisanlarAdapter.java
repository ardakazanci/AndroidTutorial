package com.ardakazanci.asynctaskloadersimple_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CalisanlarAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<Calisanlar> calisanlarList = new ArrayList<Calisanlar>();


    public CalisanlarAdapter(Context context, List<Calisanlar> calisanlars) {

        this.calisanlarList = calisanlars;
        layoutInflater = LayoutInflater.from(context);

    }


    @Override
    public int getCount() {
        return calisanlarList.size();
    }

    @Override
    public Object getItem(int position) {
        return calisanlarList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Calisanlar calisanlar = (Calisanlar) getItem(position); // emp1 , brahma

        if (convertView == null) {

            convertView = layoutInflater.inflate(R.layout.ozel_list, null); // 1 satır oluşturduk


        }

        TextView empid = (TextView) convertView.findViewById(R.id.empid);
        empid.setText(calisanlar.calisanID);
        TextView empname = (TextView) convertView.findViewById(R.id.empname);
        empname.setText(calisanlar.calisanISIM);
        return convertView;


    }


    public void setCalisan(List<Calisanlar> data) {

        calisanlarList.addAll(data);
        notifyDataSetChanged();
    }
}

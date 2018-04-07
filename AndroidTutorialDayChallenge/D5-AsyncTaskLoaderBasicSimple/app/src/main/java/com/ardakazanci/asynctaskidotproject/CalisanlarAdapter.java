package com.ardakazanci.asynctaskidotproject;

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
    private List<Calisanlar> list = new ArrayList<Calisanlar>();

    public CalisanlarAdapter(Context context, List<Calisanlar> calisanlars) {

        this.list = calisanlars;
        layoutInflater = LayoutInflater.from(context);

    }

    // Bağdaştırıcı tarafından temsil edilen veri öğelerinin sayısı
    @Override
    public int getCount() {
        return list.size();
    }

    // : Belirli bir konum için veri öğesini döndürür.
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    // Verilen konumla ilişkili satır kimliğini döndürür.
    @Override
    public long getItemId(int position) {
        return position;
    }

    // Verileri belirtilen konumda görüntülemeyi sağlayan metot.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Calisanlar calisanlar = (Calisanlar) getItem(position);

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.calisan_list, null);
        }

        TextView calisanId = (TextView) convertView.findViewById(R.id.empid);
        calisanId.setText(calisanlar.calisanId);
        TextView empname = (TextView) convertView.findViewById(R.id.empname);
        empname.setText(calisanlar.calisanIsim);
        return convertView;
    }


    public void setEmployees(List<Calisanlar> data) {
        list.addAll(data);
        notifyDataSetChanged();
    }
}

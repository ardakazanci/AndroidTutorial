package com.ardakazanci.ozellistview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class KisilerAdapter extends BaseAdapter {

    private LayoutInflater mInflater;

    private List<Kisiler> mKisiListesi;


    public KisilerAdapter(Activity activity, List<Kisiler> kisiler) {

        mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mKisiListesi = kisiler;
    }

    @Override
    public int getCount() {
        return mKisiListesi.size();
    }

    @Override
    public Object getItem(int position) {
        return mKisiListesi.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;


    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View satir;

        satir = mInflater.inflate(R.layout.listview_stil, null);

        TextView textView = satir.findViewById(R.id.isimsoyisim);

        ImageView imageView = satir.findViewById(R.id.simge);


        Kisiler kisi = mKisiListesi.get(position);

        textView.setText(kisi.getIsim());

        if (kisi.isKadinMi() == true) {

            imageView.setImageResource(R.drawable.female);

        } else {

            imageView.setImageResource(R.drawable.male);

        }


        return satir;


    }
}

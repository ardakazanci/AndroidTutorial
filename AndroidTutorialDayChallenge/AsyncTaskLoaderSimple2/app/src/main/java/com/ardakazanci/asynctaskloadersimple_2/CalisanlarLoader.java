package com.ardakazanci.asynctaskloadersimple_2;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import java.util.ArrayList;
import java.util.List;

public class CalisanlarLoader extends AsyncTaskLoader<List<Calisanlar>> {


    public CalisanlarLoader(Context context) {

        super(context);

    }


    @Nullable
    @Override
    public List<Calisanlar> loadInBackground() {

        List<Calisanlar> list = new ArrayList<Calisanlar>();
        list.add(new Calisanlar("emp1", "Brahma"));
        list.add(new Calisanlar("emp2", "Vishnu"));
        list.add(new Calisanlar("emp3", "Mahesh"));
        return list;

    }
}

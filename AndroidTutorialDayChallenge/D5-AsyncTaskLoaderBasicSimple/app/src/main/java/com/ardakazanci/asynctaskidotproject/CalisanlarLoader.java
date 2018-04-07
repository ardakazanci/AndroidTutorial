package com.ardakazanci.asynctaskidotproject;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CalisanlarLoader extends android.support.v4.content.AsyncTaskLoader {


    public CalisanlarLoader(Context context) {
        super(context);
    }


    @Nullable
    @Override
    public Object loadInBackground() {
        List<Calisanlar> list = new ArrayList<Calisanlar>();
        list.add(new Calisanlar("1", "Arda Kazancı"));
        list.add(new Calisanlar("2", "Arda Kazancıı"));
        return list;
    }


}

package com.ardakazanci.ozellistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    final List<Kisiler> kisiler = new ArrayList<Kisiler>();

    /*


        | İMAGE - CİNSİYET  | Ad Soyad
        | İMAGE - CİNSİYET  | Ad Soyad
        | İMAGE - CİNSİYET  | Ad Soyad
        | İMAGE - CİNSİYET  | Ad Soyad
        | İMAGE - CİNSİYET  | Ad Soyad
        | İMAGE - CİNSİYET  | Ad Soyad


    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kisiler.add(new Kisiler("Arda Kazancı", false));
        kisiler.add(new Kisiler("Erdinç Kaplan", false));
        kisiler.add(new Kisiler("Alara Dilara", true));
        kisiler.add(new Kisiler("Fatma Çelik", true));
        kisiler.add(new Kisiler("Umutcan Çiftçi", false));


        ListView listemiz = findViewById(R.id.liste);

        KisilerAdapter kisilerAdapter = new KisilerAdapter(this, kisiler);

        listemiz.setAdapter(kisilerAdapter);

    }


}

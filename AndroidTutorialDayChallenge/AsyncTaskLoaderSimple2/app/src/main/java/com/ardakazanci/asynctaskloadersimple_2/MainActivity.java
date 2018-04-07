package com.ardakazanci.asynctaskloadersimple_2;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Calisanlar>> {
    CalisanlarAdapter calisanlarAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calisanlarAdapter = new CalisanlarAdapter(this, new ArrayList<Calisanlar>());
        ListView employeeListView = (ListView) findViewById(R.id.calisanlar);
        employeeListView.setAdapter(calisanlarAdapter);

        getSupportLoaderManager().initLoader(1, null, this).forceLoad();

    }

    // Yeni Loader Oluşturuluyor.
    @NonNull
    @Override
    public Loader<List<Calisanlar>> onCreateLoader(int id, @Nullable Bundle args) {
        return new CalisanlarLoader(MainActivity.this);
    }

    // Loader sonlandırıldığında yapılacka işlemler
    @Override
    public void onLoadFinished(@NonNull Loader<List<Calisanlar>> loader, List<Calisanlar> data) {
        calisanlarAdapter.setCalisan(data);
    }

    // Loader yeniden başlatıldığında yapılacak işlemler.
    @Override
    public void onLoaderReset(@NonNull Loader<List<Calisanlar>> loader) {
        calisanlarAdapter.setCalisan(new ArrayList<Calisanlar>());
    }
}

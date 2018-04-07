package com.ardakazanci.asynctaskidotproject;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import android.content.AsyncTaskLoader;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Calisanlar>> {

    CalisanlarAdapter calisanlarAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calisanlarAdapter = new CalisanlarAdapter(this, new ArrayList<Calisanlar>());

        ListView employeeListView = (ListView) findViewById(R.id.employees);

        employeeListView.setAdapter(calisanlarAdapter);

        getSupportLoaderManager().initLoader(1, null, this).forceLoad();

    }


    @NonNull
    @Override
    public Loader<List<Calisanlar>> onCreateLoader(int id, @Nullable Bundle args) {
        return new CalisanlarLoader(MainActivity.this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<Calisanlar>> loader, List<Calisanlar> data) {
        calisanlarAdapter.setEmployees(data);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<Calisanlar>> loader) {

    }
}

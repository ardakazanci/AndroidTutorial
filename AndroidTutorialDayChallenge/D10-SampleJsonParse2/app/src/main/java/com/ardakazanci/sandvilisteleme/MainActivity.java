package com.ardakazanci.sandvilisteleme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] sandvicler = getResources().getStringArray(R.array.sandwich_names); // Tüm sandviç isimleri
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sandvicler);
        ListView listView = findViewById(R.id.listview_sandwich);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                activityBaslat(position);

            }
        });


    }

    private void activityBaslat(int position) {

        Intent intent = new Intent(this, DetayActivity.class);
        intent.putExtra(DetayActivity.EXTRA_POSITION, position); // ilgili pozisyon gönderiliyor.
        startActivity(intent);

    }

    ;
}

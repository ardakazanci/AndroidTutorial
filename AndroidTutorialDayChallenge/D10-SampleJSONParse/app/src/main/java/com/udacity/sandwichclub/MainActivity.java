package com.udacity.sandwichclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] sandwiches = getResources().getStringArray(R.array.sandwich_names); // Sandviç Listesi
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, sandwiches); // İçerisini Sandviç Listesi ile dolduruyor.

        // Simplification: Using a ListView instead of a RecyclerView
        ListView listView = findViewById(R.id.sandwiches_listview); // Listview çağırılıyor.
        listView.setAdapter(adapter); // Adapter'e bağlanıyor.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                launchDetailActivity(position); // Tıklanan değerin pozisyonu Metot'a gönderilyor.
            }
        });
    }

    private void launchDetailActivity(int position) { // Pozisyon bilgisine göre Niyet atılıyor.
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_POSITION, position); // Pozisyon bilgisini , Etiket ile gönderiyor.
        startActivity(intent); // Activitiy ' i başlatıyor.
    }
}

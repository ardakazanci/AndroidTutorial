package com.ardakazanci.custommenuactionbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater(); // Şişirme işlemini sağlayacak
        menuInflater.inflate(R.menu.main, menu);
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.share_click) {
            Toast.makeText(getApplicationContext(), "Paylaşım İşlemi", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.search_click) {
            Toast.makeText(getApplicationContext(), "Arama İşlemi", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }
}

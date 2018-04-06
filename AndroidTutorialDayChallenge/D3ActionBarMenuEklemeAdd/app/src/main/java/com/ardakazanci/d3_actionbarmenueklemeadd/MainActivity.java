package com.ardakazanci.d3_actionbarmenueklemeadd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.appBar);
        // Bu kontrol AppBar olarak kullanılacak toolbar kontrolünü set etmeye yarar.
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Oluşturulan XML Dosyası menü olarak kullanılır.
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main_actions, menu);
        return super.onCreateOptionsMenu(menu);

    }

    // Herbir menü seçeneğine erişmek için bu metot kullanılır.


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.search:
                Toast.makeText(getApplicationContext(), "Ara", Toast.LENGTH_LONG).show();
                return true;
            case R.id.likeit:
                Toast.makeText(getApplicationContext(), "Beğen", Toast.LENGTH_LONG).show();
                return true;
            case R.id.settings:
                Toast.makeText(getApplicationContext(), "Ayarlar", Toast.LENGTH_LONG).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

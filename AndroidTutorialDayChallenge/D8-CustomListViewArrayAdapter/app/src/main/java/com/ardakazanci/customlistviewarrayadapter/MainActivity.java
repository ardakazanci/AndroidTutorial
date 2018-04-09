package com.ardakazanci.customlistviewarrayadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ArrayList - > List
        // Generics Type : AndroidModel Class
        ArrayList<AndroidModel> androidOs = new ArrayList<AndroidModel>();

        androidOs.add(new AndroidModel("Donut","1.6",R.drawable.donut));
        androidOs.add(new AndroidModel("Eclair","2.0-2.1",R.drawable.eclair));
        androidOs.add(new AndroidModel("Froyo","2.2-2.2.3",R.drawable.froyo));
        androidOs.add(new AndroidModel("GingerBread","2.3-2.3.7",R.drawable.gingerbread));
        androidOs.add(new AndroidModel("Honeycomb","3.0-3.2.6",R.drawable.honeycomb));
        androidOs.add(new AndroidModel("Ice Cream Sandwich :P","4.0-4.0.4",R.drawable.icecream));
        androidOs.add(new AndroidModel("Jelly Bean","4.1-4.3.1",R.drawable.jellybean));
        androidOs.add(new AndroidModel("Kitkat","4.4-4.4.4",R.drawable.kitkat));
        androidOs.add(new AndroidModel("Lollipop","5.0-5.1.1",R.drawable.lollipop));
        androidOs.add(new AndroidModel("Marshmallow","6.0-6.0.1",R.drawable.marshmallow));
        // .... O ,P

        ListView listView = findViewById(R.id.listview);

        AndroidVersionAdapter adapter = new AndroidVersionAdapter(this,androidOs);

        listView.setAdapter(adapter);

        // Custom aDAPTER FNİFİİSDİİSDİASDİASDİASDİASDİA




    }
}

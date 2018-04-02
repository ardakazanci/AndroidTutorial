package com.ardakazanci.d1_activityotheractivitycontentshare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // Manifest Dosyası içerisinde her intent filter etiketine

    // category android:name="android.intent.category.DEFAULT" /> eklemeliyiz

    // implicit intent alabilmesini sağlar. 


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

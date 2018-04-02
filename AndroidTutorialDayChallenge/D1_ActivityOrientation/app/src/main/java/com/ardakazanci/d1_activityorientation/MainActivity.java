package com.ardakazanci.d1_activityorientation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // B PLANI : manifest dosyasında : android:screenOrientation="landscape" vermek yeterlidir.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
}

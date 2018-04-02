package com.ardakazanci.activitystartbutton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // APP  2 - Activity Start

    Button buttonOne, buttonTwo, buttonThree, buttonFour;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // View Elemanları Ayrı bir metotta olacak
        // Button Tıklama Olayları Farklı bir Metot'ta olacak.

        getControlView();
        setClickForView();


    }


    private void getControlView() {

        buttonOne = findViewById(R.id.bt_1);
        buttonTwo = findViewById(R.id.bt_2);
        buttonThree = findViewById(R.id.bt_3);
        buttonFour = findViewById(R.id.bt_4);


    }

    private void setClickForView() {

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Exclipt Intent
                // this, getApplicationContext Context
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                Log.i(LOG_TAG, "Buttona Tıklandı - Activity Başlatıldı");

            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent("com.ardakazanci.activitystartbutton.MainActivity2");
                startActivity(intent);

            }
        });

        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setAction("com.ardakazanci.activitystartbutton.MainActivity2");
                startActivity(intent);

            }
        });

        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent("com.ardakazanci.activitystartbutton.MainActivity2");

                startActivity(Intent.createChooser(intent, "Uygulamayı Seçiniz"));



            }
        });


    }
}

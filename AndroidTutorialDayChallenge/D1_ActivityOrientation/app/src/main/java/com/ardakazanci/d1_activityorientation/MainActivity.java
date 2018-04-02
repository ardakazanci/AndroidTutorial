package com.ardakazanci.d1_activityorientation;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // B PLANI : manifest dosyasında : android:screenOrientation="landscape" vermek yeterlidir.

    // Activity ' nin istenilen yönde başlatılmasını sağlamak

    Button button_1,button_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getControlView();
        clickForView();


    }

    private void getControlView(){

        button_1 = findViewById(R.id.button_1); //
        button_2 = findViewById(R.id.button_2);

    }


    private void clickForView(){


        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); // Yatay


            }
        });

        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // Dikey

            }
        });


    }

}

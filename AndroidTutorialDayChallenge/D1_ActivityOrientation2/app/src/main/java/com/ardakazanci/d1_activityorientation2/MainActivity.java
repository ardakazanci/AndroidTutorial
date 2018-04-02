package com.ardakazanci.d1_activityorientation2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Activity ' nin Cihaz Yönünü Algılaması


    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    Button button_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getControlView();
        setClickForView();

    }

    private void getControlView() {

        button_1 = findViewById(R.id.button_1);

    }


    private void setClickForView() {

        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Ekran Boyutları Genişlik ve Yükseklik Genişlik > Yükselik Yatay

                Display display = getWindowManager().getDefaultDisplay();

                String message = null;


                if (display.getWidth() > display.getHeight()) {

                    message = "Ekran Yatay Konumdadır";

                } else if (display.getHeight() > display.getWidth()) {

                    message = "Ekran Dikey Konumdadır";

                } else {

                    message = "Sensör Problemi Yaşanıyor.";

                }

                Toast.makeText(getApplicationContext(), "Ekran Durumu : " + message, Toast.LENGTH_LONG).show();


            }
        });

    }

}

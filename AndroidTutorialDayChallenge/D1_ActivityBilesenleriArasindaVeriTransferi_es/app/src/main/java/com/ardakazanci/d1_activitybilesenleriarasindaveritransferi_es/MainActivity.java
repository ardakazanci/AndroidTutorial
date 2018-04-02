package com.ardakazanci.d1_activitybilesenleriarasindaveritransferi_es;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getControlView();
        comingIntent();
    }

    private void getControlView() {

        textView = findViewById(R.id.textview);


    }

    private void comingIntent() {

        Intent intent = getIntent();
        String comingAction = intent.getAction();
        String comingType = intent.getType();

        if (comingAction.equals(Intent.ACTION_SEND)) { // Aksiyon SEND ise

            if (comingType.equals("text/plain")) { // Gelen veri tipi text ise

                String comingMessage = intent.getStringExtra(Intent.EXTRA_TEXT); // StringExtra yı String değişkene ata.
                textView.setText(comingMessage);

            }

        }


    }

}

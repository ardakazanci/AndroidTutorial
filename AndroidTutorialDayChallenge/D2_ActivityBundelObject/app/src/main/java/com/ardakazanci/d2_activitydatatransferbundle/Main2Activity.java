package com.ardakazanci.d2_activitydatatransferbundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView tvUserName, tvAge, tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getControlView();
        setControlView(); // Aldığım verileri gösterme işlemleri

    }

    private void getControlView() {

        tvUserName = findViewById(R.id.getUserName);
        tvAge = findViewById(R.id.getAge);
        tvEmail = findViewById(R.id.getEmail);

    }

    private void setControlView() {

        Intent i = getIntent();

        Bundle comingBundle = i.getExtras();

        String comingName = comingBundle.getString("username");

        int comingAge = comingBundle.getInt("userage");

        String comingEmail = comingBundle.getString("usermail");

        tvUserName.setText("Your Username : " + comingName);
        tvAge.setText("Your Age : " + comingAge);
        tvEmail.setText("Your Email" + comingEmail);

    }

}

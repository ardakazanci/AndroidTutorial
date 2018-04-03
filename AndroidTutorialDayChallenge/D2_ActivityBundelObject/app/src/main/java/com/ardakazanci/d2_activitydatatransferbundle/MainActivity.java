package com.ardakazanci.d2_activitydatatransferbundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btSend;
    EditText etUserName, etEmail, etAge;

    // private static final String B_USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getControlView();
        setClickForView();


    }

    private void getControlView() {

        btSend = findViewById(R.id.bt_send);
        etUserName = findViewById(R.id.et_username);
        etEmail = findViewById(R.id.et_email);
        etAge = findViewById(R.id.et_age);

    }


    private void setClickForView() {

        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendInformation();

            }
        });


    }


    private void sendInformation() {

        String userName = etUserName.getText().toString();
        int userAge = Integer.parseInt(etAge.getText().toString());
        String userEmail = etEmail.getText().toString();

        Intent i = new Intent(MainActivity.this, Main2Activity.class);

        Bundle bundle = new Bundle();


        Log.i("Info etAge : ", etAge.getText().toString());
        bundle.putString("username", userName);
        bundle.putInt("userage", userAge);
        bundle.putString("usermail", userEmail);

        i.putExtras(bundle);
        startActivity(i);


    }
}

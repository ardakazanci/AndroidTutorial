package com.ardakazanci.d1_activitybilesenleriarasindaveritransferi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getControlView();
        setClickForView();

    }

    private void getControlView() {

        editText = findViewById(R.id.edittext);
        button = findViewById(R.id.button);

    }

    private void setClickForView() {

        sendMessage();

    }

    private void sendMessage() {

        String text = editText.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, text); // Gönderilecek action extrasına ekleniyor.
        intent.setType("text/plain");
        startActivity(intent);

    }

}

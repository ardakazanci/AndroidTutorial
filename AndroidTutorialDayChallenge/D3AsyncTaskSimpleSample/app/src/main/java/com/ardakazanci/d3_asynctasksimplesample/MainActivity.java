package com.ardakazanci.d3_asynctasksimplesample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textview1);

    }


    public void startTask (View view) {
        mTextView.setText("Napping... ");

        new SimpleAsyncTask(mTextView).execute();
    }
}

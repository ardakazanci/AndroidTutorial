package com.ardakazanci.d3_activityonsaveinstancestateonrestoreinstancestate;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button bt;
    TextView tv;
    int i;

    private static final String BUNDLE_KEY = "a";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getControlView();
        setClickForView();

        if (savedInstanceState != null) {

            i = savedInstanceState.getInt(BUNDLE_KEY);
            tv.setText("Sayaç : " + i);

        }


    }

    private void getControlView() {

        bt = (Button) findViewById(R.id.bt_1);
        tv = (TextView) findViewById(R.id.tv_1);

    }

    private void setClickForView() {

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i++;
                tv.setText("Sayaç : " + i);

            }
        });


    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(BUNDLE_KEY, i);


    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        i = savedInstanceState.getInt(BUNDLE_KEY);
        tv.setText("Sayaç : " + i);

    }
}

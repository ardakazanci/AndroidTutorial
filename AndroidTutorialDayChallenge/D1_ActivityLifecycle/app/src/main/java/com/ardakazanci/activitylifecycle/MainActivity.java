package com.ardakazanci.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


// Code Kata 1 - Activity Lifecycle - Note Take
// 19:48 - 2 NİSAN - DAY 1


public class MainActivity extends AppCompatActivity {



    // Log Tag - MainActivity.class
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    // Log.i = info
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(LOG_TAG, " OnCreate Evresi ");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i(LOG_TAG, " OnStart Evresi ");

    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i(LOG_TAG, " OnResume Evresi ");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(LOG_TAG, " OnPause Evresi ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(LOG_TAG, " OnDestroy Evresi ");

    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i(LOG_TAG, " OnRestart Evresi ");

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.i(LOG_TAG, " OnSaveInstanceState Evresi ");

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.i(LOG_TAG, " onRestoreInstanceState Evresi ");

    }


}

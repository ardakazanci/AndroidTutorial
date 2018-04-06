package com.ardakazanci.d4_progressbarsampleproject;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // ProgressBar yüzdesini göstermek için view

    TextView progressBarViewPercent;

    // ProgressBar view Elemanı

    ProgressBar progressBar;

    // ProgressBar durumunu tutacak değişken

    int progressBarStatus = 0;

    // Progressbar durumunu güncellemek için Handler kullanılacak

    Handler handler = new Handler();

    // Çok uzun süren işlemleri uygulamalayı yavaşlatmadan gerçekleştirmek için Thread (Arka planda görev ) oluşturacağız.

    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getControlView();
        setThread();

        thread.start();


    }


    private void getControlView() {

        progressBar = findViewById(R.id.progressBar);
        progressBarViewPercent = findViewById(R.id.progressPercent);

    }

    private void setThread() {

        thread = new Thread(new Runnable() {
            @Override
            public void run() {

                // İşlem yüzdesi %90 %89...

                while (progressBarStatus < 100) {

                    // Eğer progressBarStatus 99 ' a eşitse activity'i sonlandır.
                    if (progressBarStatus == 99) {

                        finish();

                    }

                    try {

                        Thread.sleep(100);

                        progressBarStatus = doWork();

                        handler.post(new Runnable() {
                            @Override
                            public void run() {

                                progressBar.setProgress(progressBarStatus);
                                progressBarViewPercent.setText("%" + progressBarStatus);
                            }
                        });


                    } catch (InterruptedException e) {

                        e.printStackTrace();


                    }


                }


            }
        });

    }

    

    private int doWork() {

        return ++progressBarStatus;

    }


}

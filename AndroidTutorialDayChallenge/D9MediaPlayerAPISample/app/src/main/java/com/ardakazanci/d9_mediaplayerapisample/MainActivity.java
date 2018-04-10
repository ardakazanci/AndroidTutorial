package com.ardakazanci.d9_mediaplayerapisample;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button play, pause;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getForView();
        mediaPlayerCreate();
        clickForView();


    }

    public void mediaPlayerCreate() {

        mediaPlayer = MediaPlayer.create(this, R.raw.music);

    }

    public void getForView() {

        play = findViewById(R.id.musicPlay);
        pause = findViewById(R.id.musicPause);


    }

    public void clickForView() {

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "PLAY MUSIC", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();

            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "PAUSE MUSIC", Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();

            }
        });

    }

}

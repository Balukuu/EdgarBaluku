package com.example.baluku;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BalukuEdgar extends AppCompatActivity {

    Button play, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baluku_edgar);

        final MediaPlayer mediaPlayer= MediaPlayer.create(this, R.raw.edgarbaluku);

        play = findViewById(R.id.play_btn);
        stop = findViewById(R.id.stop_btn);

        play.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        MediaPlayer mediaPlayer =MediaPlayer.create(getApplicationContext(), R.raw.edgarbaluku);
        mediaPlayer.start();
        }
    });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MediaPlayer mediaPlayer =MediaPlayer.create(getApplicationContext(), R.raw.edgarbaluku);
                if (mediaPlayer!=null && mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }

            }
        });

    }
}


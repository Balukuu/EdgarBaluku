package com.example.baluku;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BalukuEdgar extends AppCompatActivity {

    Button play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baluku_edgar);
        final MediaPlayer mediaPlayer= MediaPlayer.create(this, R.raw.edgarbaluku);

        play = findViewById(R.id.play);
    play.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
       MediaPlayer mediaPlayer =MediaPlayer.create(getApplicationContext(), R.raw.edgarbaluku);
       mediaPlayer.start();
        }
    });

    }
}


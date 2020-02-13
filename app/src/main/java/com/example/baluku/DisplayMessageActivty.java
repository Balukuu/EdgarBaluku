package com.example.baluku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DisplayMessageActivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message_activty);
        Intent intent = getIntent();
        String message = intent.getStringExtra("MESSAGE");
        TextView messageView = (TextView)findViewById(R.id.TextView);
        messageView.setText(message);
    }

    public void onClose(View view) {
        super.finish();
    // finishes current Activity
    }

    }


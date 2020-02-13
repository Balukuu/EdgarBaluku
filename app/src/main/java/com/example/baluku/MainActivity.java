package com.example.baluku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        EditText message = findViewById(R.id.EditText);
        Intent intent = new Intent(this, DisplayMessageActivty.class);
        intent.putExtra("MESSAGE", message.getText().toString());

        startActivity(intent);

        message.setText("");
    }

}
package com.example.baluku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.menu_start:
                startActivity(new Intent(this,  BalukuEdgar.class));

                return true;
            case R.id.menu_end:
                startActivity(new Intent(this,  baluku36.class));

                return true;
            case R.id.list_view:
                startActivity(new Intent(this,  ListViewActivity.class));

                return true;
        default:
            return super.onOptionsItemSelected(item);
        }

    }

}
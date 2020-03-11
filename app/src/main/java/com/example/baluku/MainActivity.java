package com.example.baluku;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    BroadcastReceiver r = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            int battery = intent.getIntExtra("level", 0);
            ProgressBar bar = (ProgressBar) findViewById(R.id.progressBar);
            bar.setProgress(battery);
            TextView textView = (TextView) findViewById(R.id.textField);
            textView.setText("THE BATTERY LEVEL :" + Integer.toString(battery) + "%");

        }
    };

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
    public void clickMe(View view) {
        EditText startAlarm = findViewById(R.id.time);
        int time = Integer.parseInt(startAlarm.getText().toString());

        // CREATING THE INTENT AN D
        Intent intent = new Intent(this, BroadcastReceiver.class);

        //creating a pending intent
        PendingIntent pendingIntent = PendingIntent.getBroadcast
                (this.getApplicationContext(),0,intent,0);

        //real time clock
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        //CALLING THE ALARM
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+(time* 1000),
                pendingIntent);

        // TOAST TO DISPLAY THE ALARM TIME

        Toast.makeText(this, "Alarm set in"+time+"seconds", Toast.LENGTH_LONG).show();

    }

}
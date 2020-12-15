package com.example.baluku;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   private static final int REQUEST_CALL = 1;

    BroadcastReceiver r = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            int battery = intent.getIntExtra("level", 0);
            ProgressBar bar = (ProgressBar) findViewById(R.id.progressBar);
            bar.setProgress(battery);
            TextView textView = (TextView) findViewById(R.id.textField);
            String battery_level = "BATTERY LEVEL : " +
                    battery +
                    "%";

            //String battery_level = String.format("%f", battery);
            textView.setText(battery_level);
        }
    };

    // AN INNER CLASS FOR THE BROADCAST RECEIVER .
     /*
     class Receiver extends BroadcastReceiver{
       @Override
        public void onReceive(Context context, Intent intent) {
        }
     }
      */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerReceiver(r, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }



    public void clickMe(View view) {
        EditText startAlarm = findViewById(R.id.startAlarm);
        String counter_time = startAlarm.getText().toString();

        if (!counter_time.isEmpty()) {

            int time = Integer.parseInt(counter_time);

            // CREATING THE INTENT AN D
            Intent intent = new Intent(this, BroadcastReciver.class);

            //creating a pending intent
            PendingIntent pendingIntent = PendingIntent.getBroadcast
                    (this.getApplicationContext(), 0, intent, 0);

            //real time clock
            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

            //CALLING THE ALARM
            alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() +
                    (time * 1000), pendingIntent);

            // TOAST TO DISPLAY THE ALARM TIME
            Toast.makeText(this, "Alarm set in" + time + "seconds", Toast.LENGTH_LONG).show();
        } else {
            Toast toast = Toast.makeText(this, "PLEASE ENTER THE COUNTER TIME ! ",
                    Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 220);
            toast.show();
            startAlarm.requestFocus();
        }
    }

    public void sendMessage(View view) {
        EditText message = findViewById(R.id.message);
        String msg = message.getText().toString();

        if (!msg.isEmpty()) {
            Intent intent = new Intent(this, DisplayMessageActivty.class);
            intent.putExtra("MESSAGE", msg);
            startActivity(intent);

            message.setText("");

        } else {
            Toast mytoast = Toast.makeText(this, "PLEASE ENTER A MESSAGE TO SEND ! ", Toast.LENGTH_SHORT);
            mytoast.setGravity(Gravity.CENTER, 0, -600);
            mytoast.show();
            message.requestFocus();
        }

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
            case R.id.InternalExternal:
                startActivity(new Intent(this,  InternalExternal.class));

                return true;
        default:
            return super.onOptionsItemSelected(item);
        }

    }




    }


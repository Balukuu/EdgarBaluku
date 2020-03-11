package com.example.baluku;

import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Vibrator;
import android.view.Gravity;
import android.widget.Toast;

public class BroadcastReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
// TODO: This method is called when the BroadcastReceiver is receiving
// an Intent broadcast.

// TOAST DISPLAYING THE END OF THE ALARM
        Toast toast = Toast.makeText(context, "Time is UP .", Toast.LENGTH_LONG);

//SETTING THE LOCATION OF THE TOAST
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();

//vibrate the  phone
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(4000);
    }
}

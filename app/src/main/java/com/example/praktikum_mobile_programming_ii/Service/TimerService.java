package com.example.praktikum_mobile_programming_ii.Service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.praktikum_mobile_programming_ii.R;

import java.security.Provider;

public class TimerService extends Service {
    public static final String BROADCAST_ACTION = "com.example.timerservice";
    long timeInMilliseconds = 0L;
    private Intent intent;
    private Handler handler = new Handler();
    private long initial_time;
    private static final String TAG_FOREGROUND_SERVICE = "FOREGROUND_SERVICE";
    public static final String ACTION_START_FOREGROUND_SERVICE = "ACTION_START_FOREGROUND_SERVICE";
    public static final String ACTION_STOP_FOREGROUND_SERVICE = "ACTION_STOP_FOREGROUND_SERVICE";

    @Override
    public void onCreate() {
        super.onCreate();
        initial_time = SystemClock.uptimeMillis();
        intent = new Intent(BROADCAST_ACTION);
        handler.removeCallbacks(sendUpdatesToUI);
        handler.postDelayed(sendUpdatesToUI, 1000); // 1 second
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            String action = intent.getAction();
            if(action!=null)
                switch (action) {
                    case ACTION_START_FOREGROUND_SERVICE:
                        Toast.makeText(getApplicationContext(), "Service Started.", Toast.LENGTH_LONG).show();
                        break;
                }
        }
        return super.onStartCommand(intent, flags, startId);
    }



    private void stopForegroundService() {
        Log.d(TAG_FOREGROUND_SERVICE, "Stop foreground service.");

    }

    private void DisplayLoggingInfo() {
        timeInMilliseconds = SystemClock.uptimeMillis() - initial_time;

        int timer = (int) timeInMilliseconds / 1000;
        int mins = timer / 60;
        int secs = timer % 60;
        intent.putExtra("mins", mins);
        intent.putExtra("secs", secs);

        Log.d("D3MI2", "" + mins + ":" + String.format("%02d", secs));
        sendBroadcast(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(sendUpdatesToUI);
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_LONG).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private Runnable sendUpdatesToUI = new Runnable() {
        public void run() {
            DisplayLoggingInfo();
            handler.postDelayed(this, 1000); // 1 seconds
        }
    };

}
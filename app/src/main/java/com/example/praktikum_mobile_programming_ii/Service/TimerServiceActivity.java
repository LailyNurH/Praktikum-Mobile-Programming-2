package com.example.praktikum_mobile_programming_ii.Service;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.praktikum_mobile_programming_ii.R;

public class TimerServiceActivity extends AppCompatActivity {

    private TextView mTextTimer;
    private Button mButtonStart, mButtonStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_service);
        mTextTimer = findViewById(R.id.tv_timer);
        mButtonStart = findViewById(R.id.btn_start);
        mButtonStop = findViewById(R.id.btn_stop);

        setupView();
    }

    private void setupView() {
        registerReceiver(broadcastReceiver, new IntentFilter(TimerService.BROADCAST_ACTION));

        mButtonStart.setOnClickListener(view -> {
            Intent intent = new Intent(TimerServiceActivity.this, TimerService.class);
            intent.setAction(TimerService.ACTION_START_FOREGROUND_SERVICE);
            startService(intent);
        });

        mButtonStop.setOnClickListener(v -> {
            mTextTimer.setText("0:00");
            Intent intent = new Intent(TimerServiceActivity.this, TimerService.class);
            intent.setAction(TimerService.ACTION_STOP_FOREGROUND_SERVICE);
            Toast.makeText(getApplicationContext(), "Foreground service is stopped.", Toast.LENGTH_LONG).show();
            stopService(intent);
        });
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            updateUI(intent);
        }
    };

    private void updateUI(Intent intent) {
        int mins = intent.getIntExtra("mins", 0);
        int secs = intent.getIntExtra("secs", 0);
        mTextTimer.setText("" + mins + ":" + String.format("%02d", secs));
    }
}

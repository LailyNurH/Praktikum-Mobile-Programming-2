package com.example.praktikum_mobile_programming_ii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.praktikum_mobile_programming_ii.sharedpref.SharedPrefManager;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Handler handler = new Handler();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final SharedPrefManager sharedPrefManager = new SharedPrefManager(this);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (sharedPrefManager.getIsLogin()){
                    Intent i = new Intent(SplashActivity.this, com.example.praktikum_mobile_programming_ii.ProfileActivity.class);
                    finishAffinity();
                    startActivity(i);
                }else{
                    Intent i = new Intent(SplashActivity.this, com.example.praktikum_mobile_programming_ii.MainActivity.class);
                    finishAffinity();
                    startActivity(i);
                }
            }
        }, 3000);

    }
}
package com.example.praktikum_mobile_programming_ii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.praktikum_mobile_programming_ii.RoomDB.RoomDataActivity;
import com.example.praktikum_mobile_programming_ii.sharedpref.SharedPrefActivity;

public class HomeActivity extends AppCompatActivity {
    Button btntoSharedPref, btntoRoomData,btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btntoRoomData = findViewById(R.id.btnToRoomData);
        btntoSharedPref= findViewById(R.id.btnToSharedPref);
        btnLogin =  findViewById(R.id.btnLogin);

        btntoSharedPref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, SharedPrefActivity.class);
                startActivity(i);
            }
        });

        btntoRoomData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, RoomDataActivity.class);
                startActivity(i);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, com.example.praktikum_mobile_programming_ii.LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
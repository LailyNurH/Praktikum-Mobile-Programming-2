package com.example.praktikum_mobile_programming_ii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.praktikum_mobile_programming_ii.Service.TimerServiceActivity;


public class MainActivity extends AppCompatActivity {
    Button btntest,btntoFragmentActivity,btntosharedprefandroomdb;
    Button btn_timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btntest = findViewById(R.id.btntest);
        btntoFragmentActivity = findViewById(R.id.btntoFragmentActivity);
        btntosharedprefandroomdb = findViewById(R.id.btntosharedprefandroomdb);
        btn_timer = findViewById(R.id.btn_timer);


    }

    @Override
    protected void onResume() {
        super.onResume();

        btntest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getApplicationContext(), com.example.praktikum_mobile_programming_ii.ReciverActivity.class);
                intent.putExtra("welcome", "halo dari Activity");
                startActivity(intent);

            }
        });
        btntoFragmentActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, com.example.praktikum_mobile_programming_ii.WithFragmentActivity.class);
                startActivity(intent);

            }
        });
        btntosharedprefandroomdb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, com.example.praktikum_mobile_programming_ii.HomeActivity.class);
                startActivity(intent);

            }
        });

        btn_timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, TimerServiceActivity.class);
                startActivity(intent);
            }
        });



    }
}



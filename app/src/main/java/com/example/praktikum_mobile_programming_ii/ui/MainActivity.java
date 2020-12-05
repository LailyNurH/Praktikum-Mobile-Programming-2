package com.example.praktikum_mobile_programming_ii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btntest,btntoFragmentActivity,btntosharedprefandroomdb,btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btntest = findViewById(R.id.btntest);
        btntoFragmentActivity = findViewById(R.id.btntoFragmentActivity);
        btntosharedprefandroomdb = findViewById(R.id.btntosharedprefandroomdb);
        btnLogin =  findViewById(R.id.btnLogin);

    }

    @Override
    protected void onResume() {
        super.onResume();

        btntest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getApplicationContext(), ReciverActivity.class);
                intent.putExtra("welcome", "halo dari Activity");
                startActivity(intent);

            }
        });
        btntoFragmentActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, WithFragmentActivity.class);
                startActivity(intent);

            }
        });
        btntosharedprefandroomdb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);

            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}



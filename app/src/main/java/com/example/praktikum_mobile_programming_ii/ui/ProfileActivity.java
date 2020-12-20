package com.example.praktikum_mobile_programming_ii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.praktikum_mobile_programming_ii.sharedpref.SharedPrefManager;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        final SharedPrefManager sharedPrefManager = new SharedPrefManager(this);

        TextView username = findViewById(R.id.tvUsername);
        TextView password = findViewById(R.id.tvPassword);
        TextView logout = findViewById(R.id.tvLogout);
        Button btntoMain = findViewById(R.id.btntoMain);

        username.setText(sharedPrefManager.getUsername());
        password.setText(sharedPrefManager.getPassword());

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProfileActivity.this, HomeActivity.class);
                sharedPrefManager.saveIsLogin(false);
                finishAffinity();
                startActivity(i);
            }
        });

        btntoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (ProfileActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
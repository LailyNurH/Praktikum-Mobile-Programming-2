package com.example.praktikum_mobile_programming_ii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReciverActivity extends AppCompatActivity {
    String Message;
    TextView textviewWelcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciver);

        Intent intent = getIntent();
        textviewWelcome =findViewById(R.id.textviewWelcome);
        Message = intent.getStringExtra("welcome");
    }
    @Override
    protected void onResume() {
        super.onResume();

        textviewWelcome.setText(Message);
    }
}

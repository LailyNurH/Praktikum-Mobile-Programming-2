package com.example.praktikum_mobile_programming_ii.RoomDB;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.praktikum_mobile_programming_ii.R;
import com.example.praktikum_mobile_programming_ii.ui.CRUD.MainActivity2;

public class RoomDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_data);
        Button btnTambah =  findViewById(R.id.btnTambah);
        Button btnLihat =  findViewById(R.id.btnlihat);
        Button btncrud = findViewById(R.id.btncrud);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RoomDataActivity.this, AddRoomDataActivity.class);
                startActivity(i);
            }
        });

        btnLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RoomDataActivity.this, ViewRoomDataActivity.class);
                startActivity(i);
            }
        });

        btncrud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RoomDataActivity.this, MainActivity2.class);
                startActivity(i);
            }
        });

    }
}
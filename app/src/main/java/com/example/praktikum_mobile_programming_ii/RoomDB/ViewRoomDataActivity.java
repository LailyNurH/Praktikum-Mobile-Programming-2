package com.example.praktikum_mobile_programming_ii.RoomDB;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import com.example.praktikum_mobile_programming_ii.R;
import com.example.praktikum_mobile_programming_ii.RoomDB.Adapter.RecyclerViewAdapter;
import com.example.praktikum_mobile_programming_ii.RoomDB.DB.AppDatabase;
import com.example.praktikum_mobile_programming_ii.RoomDB.model.Mahasiswa;

import java.util.ArrayList;
import java.util.List;

public class ViewRoomDataActivity extends AppCompatActivity {
    RecyclerView myRecyclerview;
    RecyclerViewAdapter recycleAdapter;
    List<Mahasiswa> listMahasiswas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_room_data);
        myRecyclerview = findViewById(R.id.myRecyclerview);

        fetchDataFromRoom();
        initRecyclerView();
        setAdapter();
    }

    private void fetchDataFromRoom() {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "mahasiswa").allowMainThreadQueries().build();
        listMahasiswas = db.userDao().getAll();

        //just checking data from db
        for (int i = 0 ;i <listMahasiswas.size();i++){
            Log.e("Aplikasi",listMahasiswas.get(i).getAlamat()+i);
            Log.e("Aplikasi",listMahasiswas.get(i).getKejuruan()+i);
            Log.e("Aplikasi",listMahasiswas.get(i).getNama()+i);
            Log.e("Aplikasi",listMahasiswas.get(i).getNim()+i);
        }
    }
    private void initRecyclerView() {
        myRecyclerview.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        myRecyclerview.setLayoutManager(llm);
        recycleAdapter =new RecyclerViewAdapter(this,listMahasiswas);
    }
    private void setAdapter() {
        myRecyclerview.setAdapter(recycleAdapter);
    }
}
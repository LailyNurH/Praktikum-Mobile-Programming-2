package com.example.praktikum_mobile_programming_ii.ui.CRUD;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.praktikum_mobile_programming_ii.CRUD.CrudRoomApp;
import com.example.praktikum_mobile_programming_ii.R;
import com.example.praktikum_mobile_programming_ii.RoomDB.Adapter.RvAdapter;
import com.example.praktikum_mobile_programming_ii.RoomDB.model.Mahasiswa;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private RecyclerView rvListMahasiswa;
    private FloatingActionButton fabTambah;
    private RvAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_update);

        adapter = new RvAdapter();

        rvListMahasiswa = findViewById(R.id.rv_list_mahasiswa);
        fabTambah = findViewById(R.id.fab_tambah_data);

        rvListMahasiswa.setAdapter(adapter);

        adapter.setRemoveListener(new DataListListener() {
            @Override
            public void onRemoveClick(Mahasiswa mahasiswa) {
                adapter.removeData(mahasiswa);
            }
        });

        fabTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity2.this, TambahUbahDataActivity.class));
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        List<Mahasiswa> datas = CrudRoomApp.getInstance().getDataBase().userDao().getAll();
        adapter.setData(datas);


    }

}

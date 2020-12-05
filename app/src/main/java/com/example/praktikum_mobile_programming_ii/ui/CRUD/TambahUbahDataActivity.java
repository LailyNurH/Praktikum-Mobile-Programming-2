package com.example.praktikum_mobile_programming_ii.ui.CRUD;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.praktikum_mobile_programming_ii.CRUD.CrudRoomApp;
import com.example.praktikum_mobile_programming_ii.R;
import com.example.praktikum_mobile_programming_ii.RoomDB.Dao.MahasiswaDao;
import com.example.praktikum_mobile_programming_ii.RoomDB.model.Mahasiswa;

public class TambahUbahDataActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG_DATA_INTENT = "data_mahasiswa" ;

    private EditText etNama, etNim;
    private Button btnTambah;
    private MahasiswaDao dao;
    private Mahasiswa mahasiswa;
    private Object view;


        @SuppressLint("SetTextI18n")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tambah_ubah_data);
            dao = CrudRoomApp.getInstance().getDataBase().userDao();

            if (getIntent() != null) {
                int id = getIntent().getIntExtra(TAG_DATA_INTENT, 0);
                mahasiswa = dao.findById(id);
            }

            etNama = findViewById(R.id.etNama);
            etNim = findViewById(R.id.etNim);
            btnTambah = findViewById(R.id.btn_tambah);

            if (mahasiswa != null) {
                etNama.setText(mahasiswa.getNama());
                etNim.setText(mahasiswa.getNim());
                btnTambah.setText("Ubah Data");
            }

            btnTambah.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            addOrUpdate();
            if (mahasiswa.getId() == 0) {
                dao.insertData(mahasiswa);
            } else {
                dao.update(mahasiswa);
            }

            Toast.makeText(this, btnTambah.getText().toString(), Toast.LENGTH_SHORT).show();
            finish();
        }

        private void addOrUpdate() {
            if (mahasiswa == null) {
                mahasiswa = new Mahasiswa();
            }
            mahasiswa.setNama(etNama.getText().toString());
            mahasiswa.setNim(etNim.getText().toString());
        }

    }

package com.example.praktikum_mobile_programming_ii.RoomDB.DB;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.praktikum_mobile_programming_ii.RoomDB.Dao.MahasiswaDao;
import com.example.praktikum_mobile_programming_ii.RoomDB.model.Mahasiswa;

@Database(entities = {Mahasiswa.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public  abstract MahasiswaDao userDao();
}

package com.example.praktikum_mobile_programming_ii.RoomDB.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.praktikum_mobile_programming_ii.RoomDB.model.Mahasiswa;

import java.util.List;

@Dao
public interface MahasiswaDao {

    @Query("SELECT * FROM mahasiswa")
    List<Mahasiswa> getAll();

    //Example Custum Query
    @Query("SELECT * FROM mahasiswa WHERE nama LIKE :nama ")
    Mahasiswa findByName(String nama);

    @Insert
    void insertAll(Mahasiswa... mahasiswa);

    @Delete
    public void deleteUsers(Mahasiswa... users);

    @Query("SELECT * FROM mahasiswa WHERE id LIKE :mahasiswaId LIMIT 1")
    Mahasiswa findById(int mahasiswaId);

    @Update
    void update(Mahasiswa mahasiswa);

    @Insert
    void insertData(Mahasiswa mahasiswa);

    @Delete
    void delete(Mahasiswa mahasiswa);
}
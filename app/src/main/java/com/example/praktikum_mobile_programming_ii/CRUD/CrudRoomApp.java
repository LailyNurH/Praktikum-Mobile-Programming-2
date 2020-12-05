package com.example.praktikum_mobile_programming_ii.CRUD;

import android.app.Application;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.room.Room;

import com.example.praktikum_mobile_programming_ii.RoomDB.DB.AppDatabase;

import static java.time.chrono.IsoChronology.INSTANCE;

public class CrudRoomApp extends Application {

    private static CrudRoomApp INSTANCE;
    private AppDatabase dataBase;

    public static CrudRoomApp getInstance() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        dataBase = Room.databaseBuilder(this,AppDatabase.class,"database_mahasiswa")
                .allowMainThreadQueries().build();

        INSTANCE = this;
    }
    public AppDatabase getDataBase() {
        return dataBase;
    }

}


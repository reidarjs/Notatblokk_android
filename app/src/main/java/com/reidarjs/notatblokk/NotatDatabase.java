package com.reidarjs.notatblokk;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Notat.class}, version = 1)
public abstract class NotatDatabase extends RoomDatabase {
    public abstract NotatDao notatDao();

    static NotatDatabase instance;

    public static NotatDatabase getInstance(Context context){
        if(instance==null){
            instance = Room.databaseBuilder(context,NotatDatabase.class,"db-notater").allowMainThreadQueries().build();
        }
        return instance;
    }

}



package com.reidarjs.notatblokk;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NotatDao {

    @Insert
    void insertNotat(Notat notat);

    @Delete
    void delete(Notat notat);

    @Update
    void update(Notat notat);

    @Query("SELECT * FROM notater")
    List<Notat> getNotater();

    @Query("SELECT * FROM notater WHERE id==:id")
    Notat loadNotat(int id);


}

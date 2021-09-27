package com.reidarjs.notatblokk;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notater")
public class Notat {


    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name="tittel")
    public String tittel;

    @ColumnInfo(name="notat")
    public String notat;

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public void setNotat(String notat) {
        this.notat = notat;
    }
}

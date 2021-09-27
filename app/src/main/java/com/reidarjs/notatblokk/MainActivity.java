package com.reidarjs.notatblokk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView tittelListe;
    List<Notat> notater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        NotatDatabase db=NotatDatabase.getInstance(this.getApplicationContext());
        NotatDao notatDao = db.notatDao();
        DatabaseAccess.notatDatabase=db;
        DatabaseAccess.notatDao=notatDao;


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateTitler();

    }

    public void nytt_notat(View view){
        Intent start_edit_activity = new Intent(this.getApplicationContext(),EditActivity.class);
        startActivity(start_edit_activity);
    }


    public void onResume(){
        super.onResume();
        updateTitler();
    }


    public void updateTitler(){
        notater = DatabaseAccess.notatDao.getNotater();
        tittelListe = findViewById(R.id.alleTitler);

        TittelAdapter tittelAdapter = new TittelAdapter(notater);
        RecyclerView.LayoutManager manager=new LinearLayoutManager(this);
        tittelListe.setLayoutManager(manager);
        tittelListe.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        tittelListe.setAdapter(tittelAdapter);
    }

}
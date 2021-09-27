package com.reidarjs.notatblokk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {

    EditText editTextTittel,editTextNotat;
    ImageButton btnLagre;
    int id;
    boolean isLoaded=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        initViews();

        Bundle to_load=getIntent().getExtras();
        System.out.println(to_load);
        if(to_load!=null){
            editTextTittel.setText(to_load.getString("tittel"));
            editTextNotat.setText(to_load.getString("notat"));
            isLoaded=true;
            id=to_load.getInt("id");
        }



    }


    public void lagre(View view){

        String tittel=editTextTittel.getText().toString();
        String notat=editTextNotat.getText().toString();
        Notat for_lagring=new Notat();
        for_lagring.setTittel(tittel);
        for_lagring.setNotat(notat);

        NotatDao notatDao=DatabaseAccess.notatDao;

        if(isLoaded){
            for_lagring.id=id;
            notatDao.update(for_lagring);
        }else{
            notatDao.insertNotat(for_lagring);
        }

        Toast.makeText(this,"Notat lagret",Toast.LENGTH_SHORT).show();
    }

    void initViews(){
        editTextTittel=findViewById(R.id.editTextTittel);
        editTextNotat=findViewById(R.id.editTextNotat);
        btnLagre=findViewById(R.id.btnLagre);
    }
}
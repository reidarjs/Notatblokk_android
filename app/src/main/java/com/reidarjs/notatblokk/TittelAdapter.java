package com.reidarjs.notatblokk;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TittelAdapter extends RecyclerView.Adapter<TittelAdapter.TittelViewHolder> {

    List<Notat> notater;
    NotatDao notatDao;

    public TittelAdapter(List<Notat> notater) {
        this.notater=notater;
    }

    @NonNull
    @Override
    public TittelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.tittel_recycable_element,parent,false);
        return new TittelViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull TittelViewHolder holder, int position) {
        Notat notat = notater.get(position);
        holder.tittel.setText(notat.tittel);
        holder.id=notat.id;
        notatDao=DatabaseAccess.notatDao;

        holder.slett.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notatDao.delete(notat);
                notater.remove(notat);
                notifyDataSetChanged();
            }
        });

        holder.tittel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notat loadedNotat = notatDao.loadNotat(notat.id);

                Intent load = new Intent(v.getContext(),EditActivity.class);
                load.putExtra("tittel",loadedNotat.tittel);
                load.putExtra("notat",loadedNotat.notat);
                load.putExtra("id",loadedNotat.id);
                v.getContext().startActivity(load);

            }
        });


    }



    @Override
    public int getItemCount() {
        return notater.size();
    }


    static class TittelViewHolder extends RecyclerView.ViewHolder{
        TextView tittel;
        ImageButton slett;
        int id;
        public TittelViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tittel=itemView.findViewById(R.id.txtTittel);
            this.slett=itemView.findViewById(R.id.btnSlett);

        }
    }
}

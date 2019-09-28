package com.example.tecsup.retrofit.Adaptador;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.tecsup.retrofit.Detalle_Pokemon;
import com.example.tecsup.retrofit.MainActivity;
import com.example.tecsup.retrofit.R;

public class PokedexHolder extends RecyclerView.ViewHolder {
    TextView nombrePokemon;
    Context context;
    CardView cv;
    public PokedexHolder(@NonNull View itemView, Context c) {
        super(itemView);
        this.context = c;
        nombrePokemon = itemView.findViewById(R.id.nombre_pokemon);
        cv =itemView.findViewById(R.id.card);
        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent((MainActivity) context,Detalle_Pokemon.class);
                context.startActivity(intent);
            }
        });
    }
}

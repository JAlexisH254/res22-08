package com.example.pokedex.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokedex.DetallePokemon;
import com.example.pokedex.MainActivity;
import com.example.pokedex.R;

public class PokedexHolder extends RecyclerView.ViewHolder {
    TextView nombrePokemon;
    CardView cv;
    Context context;

    public PokedexHolder(@NonNull View itemView, Context c) {
        super(itemView);
        this.context = c;
        nombrePokemon = itemView.findViewById(R.id.nombre_pokemon);
        cv = itemView.findViewById(R.id.card_view);
        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Mandar a una nueva actividad
                Intent intent = new Intent(context, DetallePokemon.class);
                context.startActivity(intent);
            }
        });
    }
}

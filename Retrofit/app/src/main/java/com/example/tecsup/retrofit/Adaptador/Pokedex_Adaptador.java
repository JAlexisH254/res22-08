package com.example.tecsup.retrofit.Adaptador;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tecsup.retrofit.Pokemon;

import java.util.List;

public class Pokedex_Adaptador extends RecyclerView.Adapter<PokedexHolder> {
    Context context;
    int layout;
    List<Pokemon> datos;
    LayoutInflater layoutInflater;

    public Pokedex_Adaptador(Context context, int layout, List<Pokemon> datos) {
        this.context = context;
        this.layout = layout;
        this.datos = datos;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public PokedexHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = layoutInflater.inflate(layout,viewGroup,false);
        return new PokedexHolder(v,context);
    }

    @Override
    public void onBindViewHolder(@NonNull PokedexHolder pokedexHolder, int i) {
        pokedexHolder.nombrePokemon.setText(datos.get(i).getName());
        //pokedexHolder.id = datos.get(i).getId();
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }
}

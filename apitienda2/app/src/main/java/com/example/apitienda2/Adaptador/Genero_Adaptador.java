package com.example.apitienda2.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apitienda2.Genero;

import java.util.List;

public class Genero_Adaptador extends RecyclerView.Adapter<GeneroHolder> {
    Context context;
    int layout;
    Genero datos;
    LayoutInflater inflador;

    public Genero_Adaptador(Context context, int layout, Genero datos) {
        this.context = context;
        this.layout = layout;
        this.datos = datos;
        inflador = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public GeneroHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflador.inflate(layout,parent,false);
        return new GeneroHolder(v, context);
    }

    @Override
    public void onBindViewHolder(@NonNull GeneroHolder holder, int position) {
        holder.nombreGenero.setText(datos.getDescripcion());

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

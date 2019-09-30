package com.example.tienda3.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tienda3.Categoria;

import java.util.List;

public class CategoriaAparter extends RecyclerView.Adapter<CategoriaHolder> {
    Context context;
    int layout;
    List<Categoria> datos;
    LayoutInflater layoutInflater;

    public CategoriaAparter(Context context, int layout, List<Categoria> datos) {
        this.context = context;
        this.layout = layout;
        this.datos = datos;
        layoutInflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public CategoriaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(layout,parent, false);
        return new CategoriaHolder(v, context);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaHolder holder, int position) {
        Categoria categoria = datos.get(position);
        holder.nombreCategoria.setText(categoria.getDescripcion());
        Glide.with(context).load(categoria.getImagen_cuadrada()).into(holder.imagenCategoria);
        holder.id = datos.get(position).getId();
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }
}

package com.example.tecsup.tiendafragment.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.tecsup.tiendafragment.Entidades.Categoria;
import com.example.tecsup.tiendafragment.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdaptadorCategoria extends RecyclerView.Adapter<CategoriaHolder> {
    Context context;
    CategoriaHolder.CategoriCallBack callBack;
    List<Categoria> datos;

    public AdaptadorCategoria(Context context, CategoriaHolder.CategoriCallBack callBack, List<Categoria> datos) {
        this.context = context;
        this.callBack = callBack;
        this.datos = datos;
    }

    @NonNull
    @Override
    public CategoriaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_castegoria,parent,false);
        return new CategoriaHolder(view,callBack);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaHolder holder, int position) {
        Glide.with(context).load(datos.get(position).getImagen_cuadrada()).into(holder.btn_categoria);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

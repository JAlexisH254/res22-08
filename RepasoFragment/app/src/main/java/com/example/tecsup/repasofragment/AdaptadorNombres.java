package com.example.tecsup.repasofragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class AdaptadorNombres extends RecyclerView.Adapter<HolderNombres> {
    Context context;
    int layout;
    List<String> datos;
    LayoutInflater layoutInflater;

    public AdaptadorNombres(Context context, int layout, List<String> datos) {
        this.context = context;
        this.layout = layout;
        this.datos = datos;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public HolderNombres onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = layoutInflater.inflate(layout,viewGroup,false);
        return new HolderNombres(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderNombres holderNombres, int i) {
        holderNombres.textView.setText(datos.get(i));

    }

    @Override
    public int getItemCount() {
        return datos.size();
    }
}

package com.example.tecsup.recycler_demo2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Item_holder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView titulo;
    TextView fecha;
    ImageButton opciones;
    ImageButton favoritos;
    int posicion;
    public Item_holder(@NonNull View itemView, final adapter_album adaptador) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imagen);
        titulo = itemView.findViewById(R.id.titulo);
        fecha = itemView.findViewById(R.id.fecha);
        opciones = itemView.findViewById(R.id.opciones);
        favoritos = itemView.findViewById(R.id.favorito);
        favoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adaptador.SetFaborito(posicion);
            }
        });
    }
}

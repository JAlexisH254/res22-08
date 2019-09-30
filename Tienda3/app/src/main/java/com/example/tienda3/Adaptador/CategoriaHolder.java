package com.example.tienda3.Adaptador;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tienda3.R;

public class CategoriaHolder extends RecyclerView.ViewHolder {
    TextView nombreCategoria;
    ImageView imagenCategoria;
    CardView cv;
    Context context;

    public CategoriaHolder(@NonNull View itemView, Context c) {
        super(itemView);
        this.context = c;
        nombreCategoria = itemView.findViewById(R.id.tv_categoria);
        imagenCategoria = itemView.findViewById(R.id.iv_categoria);
    }
}

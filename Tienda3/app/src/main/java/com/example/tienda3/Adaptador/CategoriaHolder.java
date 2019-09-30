package com.example.tienda3.Adaptador;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tienda3.CategoriaLv2;
import com.example.tienda3.Interface_Categoria;
import com.example.tienda3.R;

public class CategoriaHolder extends RecyclerView.ViewHolder {
    TextView nombreCategoria;
    ImageView imagenCategoria;
    CardView cv;
    Context context;
    int id;

    public CategoriaHolder(@NonNull View itemView, Context c) {
        super(itemView);
        this.context = c;
        nombreCategoria = itemView.findViewById(R.id.tv_categoria);
        imagenCategoria = itemView.findViewById(R.id.iv_categoria);
        cv = itemView.findViewById(R.id.cv_vista);
        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  intent = new Intent(context, CategoriaLv2.class);
                intent.putExtra("id_categoria", id);
                context.startActivity(intent);
            }
        });
    }
}

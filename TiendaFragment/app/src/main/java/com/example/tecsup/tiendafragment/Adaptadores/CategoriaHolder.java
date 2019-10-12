package com.example.tecsup.tiendafragment.Adaptadores;

import android.view.View;
import android.widget.ImageButton;

import com.example.tecsup.tiendafragment.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoriaHolder extends RecyclerView.ViewHolder{
    public ImageButton btn_categoria;
    public int id;
    public CategoriCallBack callBack;

    public CategoriaHolder(@NonNull View itemView, CategoriCallBack c) {
        super(itemView);
        this.callBack = c;
        btn_categoria=itemView.findViewById(R.id.img_categoria);
        btn_categoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.CategoriaSeleccionada(id);
            }
        });
    }

    public interface CategoriCallBack{
        public void CategoriaSeleccionada(int id);
    }
}

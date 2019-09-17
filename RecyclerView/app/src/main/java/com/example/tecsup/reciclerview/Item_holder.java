package com.example.tecsup.reciclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Item_holder extends RecyclerView.ViewHolder {

    CardView cardView;
    TextView textView;
    ImageView imageView;
    Adaptador_rv adaptador;


    public Item_holder(@NonNull View itemView, final Adaptador_rv adaptador) {
        super(itemView);
        this.adaptador = adaptador;
        imageView = itemView.findViewById(R.id.imagen);
        textView = itemView.findViewById(R.id.item_text);
        cardView = itemView.findViewById(R.id.card);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(adaptador.context,textView.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}

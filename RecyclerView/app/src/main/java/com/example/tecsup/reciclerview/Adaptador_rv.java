package com.example.tecsup.reciclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adaptador_rv extends RecyclerView.Adapter<Item_holder> {
    Context context;
    List<item> datos;
    LayoutInflater inflater;

    public Adaptador_rv(Context context, List<item> datos) {
        this.context = context;
        this.datos = datos;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Item_holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = inflater.inflate(R.layout.recycler_item, viewGroup, false);
        return new Item_holder(v,this);
    }

    @Override
    public void onBindViewHolder(@NonNull Item_holder item_holder, int i) {
        item_holder.textView.setText(datos.get(i).texto);
        Glide.with(context).load(datos.get(i).getUrl_imagen()).into(item_holder.imageView);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }
}

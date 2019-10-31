package com.example.tecsup.repasofragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class HolderNombres extends RecyclerView.ViewHolder {
    public TextView textView;
    public HolderNombres(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.nombre);
    }
}

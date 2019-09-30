package com.example.apitienda2.Adaptador;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apitienda2.R;

public class GeneroHolder extends RecyclerView.ViewHolder {
    TextView nombreGenero;
    CardView cv;
    Context context;

    public GeneroHolder(@NonNull View itemView, Context c) {
        super(itemView);
        this.context = c;
        nombreGenero = itemView.findViewById(R.id.tv);

    }
}

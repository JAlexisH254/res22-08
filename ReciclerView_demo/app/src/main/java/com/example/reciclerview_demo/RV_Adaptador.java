package com.example.reciclerview_demo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RV_Adaptador extends RecyclerView.Adapter<RV_Adaptador.ViewHolder> {


    public class ViewHolder extends  RecyclerView.ViewHolder{
        private TextView txt_genero;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_genero = itemView.findViewById(R.id.txt_genero);
        }

    }

    public List<generoListas> generoLista;

    public RV_Adaptador(List<generoListas> generoLista) {
        this.generoLista = generoLista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.genero,parent,false);
        ViewHolder viewholder = new ViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txt_genero.setText(generoLista.get(position).getListaDeGeneros());
    }

    @Override
    public int getItemCount() {
        return generoLista.size();
    }
}

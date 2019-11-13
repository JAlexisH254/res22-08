package com.example.tecsup.chatt;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MensajeHolder> {
    Context context;
    int layout;
    List<String> datos;
    LayoutInflater layoutInflater;

    public ChatAdapter(Context context, int layout, List<String> datos) {
        this.context = context;
        this.layout = layout;
        this.datos = datos;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MensajeHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(layout,viewGroup, false);
        return new MensajeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MensajeHolder mensajeHolder, int i) {
        mensajeHolder.mensaje.setText(datos.get(i));


    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public class MensajeHolder extends RecyclerView.ViewHolder{
        TextView usuario;
        TextView mensaje;
        public MensajeHolder(@NonNull View itemView) {
            super(itemView);
            usuario = itemView.findViewById(R.id.txtUsuario);
            mensaje = itemView.findViewById(R.id.txtitemmensaje);
        }
    }
}

package com.example.tecsup.menus03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class producto_adapter extends BaseAdapter {
    Context context;
    int layout;
    List<productos> datos;

    public producto_adapter(Context context, int layout, List<productos> datos) {
        this.context = context;
        this.layout = layout;
        this.datos = datos;
    }

    @Override
    public int getCount() {
        return datos.size();
    }

    @Override
    public Object getItem(int position) {
        return datos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(layout,null);

        TextView nombre = v.findViewById(R.id.nombre);
        nombre.setText(datos.get(position).getNombre());

        //TextView precio = v.findViewById(R.id.precio);
        //nombre.setText(datos.get(position).getPrecio());

        ImageView image = v.findViewById(R.id.imagen);
        Glide.with(context).load(datos.get(position).imagen).into(image);
        return v;

    }
}

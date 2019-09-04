package com.example.tecsup.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tecsup.myapplication.R;

import java.util.List;

public class AdaptadoSpinner extends BaseAdapter {
    Context c;
    List<Persona> datos;
    int layout;

    public AdaptadoSpinner(Context c, List<Persona> datos, int layout) {
        this.c = c;
        this.datos = datos;
        this.layout = layout;
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
        LayoutInflater inflater = LayoutInflater.from(c);
        convertView = inflater.inflate(layout,null);
        TextView tv = convertView.findViewById(R.id.txt_spinner);
        tv.setText(datos.get(position).nombre);

        TextView t1 = convertView.findViewById(R.id.txt_spinner2);
        tv.setText(datos.get(position).dni);

        ImageView im = convertView.findViewById(R.id.icono);
        im.setImageResource(datos.get(position).icono);
        return convertView;
    }
}
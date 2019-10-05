package com.example.tecsup.biblioteca;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class LibrosAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Libro> datos;

    public LibrosAdapter(Context context, int layout, List<Libro> datos) {
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
        convertView = inflater.inflate(layout,null);
        TextView tv = convertView.findViewById(R.id.ytxt_libro);
        TextView autor = convertView.findViewById(R.id.ytxt_autor);
        TextView isbn = convertView.findViewById(R.id.ytxt_isbn);
        tv.setText(datos.get(position).titulo);
        autor.setText(datos.get(position).autor);
        isbn.setText(datos.get(position).isbn);
        return convertView;
    }
}

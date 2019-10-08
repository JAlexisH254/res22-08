package com.example.tecsup.ventas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdaptadorVentas extends BaseAdapter {
    Context context;
    int layout;
    List<Pedidos> datos;
    List<Clientes> clientes;

    public AdaptadorVentas(Context context, int layout, List<Pedidos> datos, List<Clientes> clientes) {
        this.context = context;
        this.layout = layout;
        this.datos = datos;
        this.clientes = clientes;
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
        convertView = LayoutInflater.from(context).inflate(layout,null);
        TextView nombre = convertView.findViewById(R.id.txt_nombre);
        TextView fecha = convertView.findViewById(R.id.txt_fecha);
        TextView total = convertView.findViewById(R.id.txt_total);
        nombre.setText(clientes.get(position).getNombres() +" "+ clientes.get(position).getApellidos());
        fecha.setText(datos.get(position).getFecha());
        total.setText(datos.get(position).getTotal());

        return convertView;
    }
}

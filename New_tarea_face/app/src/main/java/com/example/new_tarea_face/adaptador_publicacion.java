package com.example.new_tarea_face;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class adaptador_publicacion extends BaseAdapter {
    Context context;
    int layout;
    List<publicacion> datos;

    public adaptador_publicacion(Context context, int layout, List<publicacion> datos) {
        this.context = context;
        this.layout = layout;
        this.datos = datos;
    }

    @Override
    public int getCount() {
        return datos.size();
    }

    @Override
    public Object getItem(int i) {
        return datos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(layout, null);

        ImageView foto = v.findViewById(R.id.v_foto);
        TextView nombre = v.findViewById(R.id.v_nombre);
        TextView fecha = v.findViewById(R.id.v_fecha);
        TextView publicacion = v.findViewById(R.id.v_publicacion);
        ImageView imagen = v.findViewById(R.id.v_imagen);

        foto.setImageDrawable(datos.get(i).foto);
        nombre.setText(datos.get(i).nombre);
        fecha.setText(datos.get(i).fecha);
        publicacion.setText(datos.get(i).publicacion);
        imagen.setImageDrawable(datos.get(i).imagen);

        return v;
    }
}

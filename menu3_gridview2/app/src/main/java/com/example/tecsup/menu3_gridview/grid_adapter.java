package com.example.tecsup.menu3_gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class grid_adapter extends BaseAdapter {
    Context contexto;
    int layout;
    List<String> datos;

    public grid_adapter(Context contexto, int layout, List<String> datos) {
        this.contexto = contexto;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(contexto);
        View v = inflater.inflate(layout, null);
        TextView tv = v.findViewById(R.id.textView);
        tv.setText(datos.get(position));
        Button b = v.findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(contexto,datos.get(position),Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
}

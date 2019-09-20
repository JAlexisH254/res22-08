package com.example.tecsup.recycler_demo2;

import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    List<Album> datos;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.recycler_view);
        fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarCreacion();
            }
        });

        datos = new LinkedList<>();
        datos.add(new Album("Mega toneras 2019","2019","https://i.ytimg.com/vi/7d5s-El33_c/hqdefault.jpg",false));

        adapter_album adaptador = new adapter_album(datos,MainActivity.this);
        rv.setAdapter(adaptador);
        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    void  mostrarCreacion(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("agregar nuevo");
        builder.setMessage("esta agregando nuevo");
        final View v = LayoutInflater.from(this).inflate(R.layout.album_fromu,null);
        builder.setView(v);
        builder.setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText nombre = v.findViewById(R.id.et_nombre);
                EditText fecha = v.findViewById(R.id.et_fecha);
                EditText imagen= v.findViewById(R.id.et_imagen);
                datos.add(new Album(nombre.getText().toString(),fecha.getText().toString(),imagen.getText().toString(),false));
            }
        });
        builder.show();


    }
}

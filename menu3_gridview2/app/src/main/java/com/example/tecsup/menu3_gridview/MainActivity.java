package com.example.tecsup.menu3_gridview;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    List<String> datos;
    grid_adapter adapter;
    Button btn_agregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridview);
        btn_agregar = findViewById(R.id.btn_agregar);

        datos = new ArrayList<>();
        datos.add("hola");
        datos.add("mundo");

        adapter = new grid_adapter(this,R.layout.pantalla,datos);
        gridView.setAdapter(adapter);

        btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MostarDialgloAggar();
            }
        });

    }

    void MostarDialgloAggar(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("crear boton");
        builder.setMessage("numeor date");

        View v = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_item_for, null);
        final EditText et= v.findViewById(R.id.editText2);
        builder.setView(v);

        builder.setPositiveButton("agrear", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                CrearMNuevoItem(et.getText().toString());
            }
        });
        builder.show();
    }

    void CrearMNuevoItem(String s){
        datos.add(s);
        adapter.notifyDataSetChanged();
    }
}

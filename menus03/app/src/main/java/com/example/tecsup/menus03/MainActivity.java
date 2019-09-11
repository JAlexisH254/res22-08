package com.example.tecsup.menus03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<productos> datos;
    EditText nombre;
    EditText precio;
    EditText imagen;
    Button agregar;
    Button eliminar;
    producto_adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lv_1);
        nombre = findViewById(R.id.et_nombre);
        precio = findViewById(R.id.et_precio);
        imagen = findViewById(R.id.et_imagen);
        agregar = findViewById(R.id.btn_agregar);
        eliminar = findViewById(R.id.btn_eliminar);
        datos = new ArrayList<>();

        for(int i =0;i<100;i++){
            datos.add(new productos("numero: "+i,(double)i,"https://i.blogs.es/2b7c9a/moon-colors/1366_2000.jpg"));
        }
        adapter = new producto_adapter(this,R.layout.item_producto, datos);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,""+ position, Toast.LENGTH_SHORT).show();
                MostrarMenu(view, position);
            }
        });

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.add(new productos(nombre.getText().toString(),Double.parseDouble(precio.getText().toString()),imagen.getText().toString()));
                adapter.notifyDataSetChanged();
            }
        });

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EliminarPrimero();
            }
        });

    }

    void EliminarPrimero(){
        datos.remove(0);
        adapter.notifyDataSetChanged();
    }

    void  MostrarMenu(View v, final int i){
        PopupMenu menu = new PopupMenu(this,v);

        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_editar:
                        break;
                    case R.id.menu_eliminar:
                        datos.remove(i);
                        adapter.notifyDataSetChanged();
                        break;
                }
                return true;
            }
        });
        menu.inflate(R.menu.producto);
        menu.show();
    }

}

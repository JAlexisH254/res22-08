package com.example.tecsup.biblioteca;

import android.content.DialogInterface;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    Realm realm;
    ListView listaLibros;
    RealmResults<Libro> libros;
    LibrosAdapter adapter;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaLibros = findViewById(R.id.ListaLibros);
        fab = findViewById(R.id.floatingActionButton);

        realm = Realm.getDefaultInstance();
        libros = realm.where(Libro.class).findAll();
        adapter = new LibrosAdapter(MainActivity.this,R.layout.libro_item,libros);
        listaLibros.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CrearLibros();
                adapter.notifyDataSetChanged();
            }
        });
    }

    void CrearLibros(){

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Crear libro");
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        View v = inflater.inflate(R.layout.form_libro,null);
        final EditText titulo= v.findViewById(R.id.titulo);
        final EditText paginas = v.findViewById(R.id.numpaginas);
        final EditText isbn = v.findViewById(R.id.isbn);
        final EditText autor = v.findViewById(R.id.autor);
        builder.setView(v);
        builder.setPositiveButton("Crear", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                realm.beginTransaction();
                Libro i = new Libro(titulo.getText().toString(),Integer.parseInt(paginas.getText().toString()),autor.getText().toString(),isbn.getText().toString());
                realm.copyToRealm(i);
                realm.commitTransaction();
                adapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }
}

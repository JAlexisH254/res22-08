package com.example.tecsup.reciclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<item> datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        datos = new LinkedList<>();
        datos.add(new item("Primer elemento","https://i.blogs.es/2b7c9a/moon-colors/450_1000.jpg"));
        datos.add(new item("Segundo elemento","https://i.blogs.es/aa1b9a/luna-100mpx/450_1000.jpg"));
        datos.add(new item("Tercero elemento","https://s1.latercera.com/wp-content/uploads/2019/09/saturno-ESA.png"));

        Adaptador_rv  adapter = new Adaptador_rv(this,datos);
        recyclerView.setAdapter(adapter);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

    }
}
package com.example.tienda3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.tienda3.Adaptador.CategoriaAparter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CategoriaLv2 extends AppCompatActivity {
    RecyclerView rv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_lv2);
        getSupportActionBar().hide();
        rv2 = findViewById(R.id.lista2);
        Intent intent = getIntent();
        int id = intent.getIntExtra("id_categoria",0);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://viveyupi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Interface_Categoria2 ic2 = retrofit.create(Interface_Categoria2.class);
        Call<List<Categoria>> servicio = ic2.listCategorias2(id);
        servicio.enqueue(new Callback<List<Categoria>>() {
            @Override
            public void onResponse(Call<List<Categoria>> call, Response<List<Categoria>> response) {
                List<Categoria> categoria = response.body();
                CategoriaAparter categoriaAparter= new CategoriaAparter(CategoriaLv2.this, R.layout.item_categoria,categoria);
                rv2.setAdapter(categoriaAparter);
                rv2.setLayoutManager(new GridLayoutManager(CategoriaLv2.this,2));
            }

            @Override
            public void onFailure(Call<List<Categoria>> call, Throwable t) {

            }
        });


    }
}

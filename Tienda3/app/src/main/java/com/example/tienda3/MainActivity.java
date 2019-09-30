package com.example.tienda3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.tienda3.Adaptador.CategoriaAparter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        rv =findViewById(R.id.lista);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://viveyupi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Interface_Categoria ic =retrofit.create(Interface_Categoria.class);
        Call<List<Categoria>> servicio = ic.listCategorias("json");

        servicio.enqueue(new Callback<List<Categoria>>() {
            @Override
            public void onResponse(Call<List<Categoria>> call, Response<List<Categoria>> response) {
                switch (response.code()){
                    case 200:
                        List<Categoria> categoria = response.body();
                        CategoriaAparter categoriaAparter=
                                new CategoriaAparter(MainActivity.this, R.layout.item_categoria,categoria);
                        rv.setAdapter(categoriaAparter);
                        rv.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
                        break;
                }
            }

            @Override
            public void onFailure(Call<List<Categoria>> call, Throwable t) {

            }
        });


    }
}

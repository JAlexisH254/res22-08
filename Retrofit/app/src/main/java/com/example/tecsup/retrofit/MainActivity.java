package com.example.tecsup.retrofit;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SearchView;


import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.tecsup.retrofit.Adaptador.Pokedex_Adaptador;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    SearchView searchView;
    List<Pokemon> pokelista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);

        CargarPokedex();
        Toolbar toolbar = findViewById(R.id.toolbar);
        searchView = findViewById(R.id.buscador);
        setSupportActionBar(toolbar);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<Pokemon> poketem = new ArrayList<>();
                for (Pokemon poke :pokelista){
                    if (poke.name.contains(newText)){
                        poketem.add(poke);
                    }
                }
                Pokedex_Adaptador pokedex_adaptador = new Pokedex_Adaptador(MainActivity.this,R.layout.item_pokedex,poketem);
                recyclerView.setAdapter(pokedex_adaptador);
                return false;
            }
        });



    }

    void CargarPokedex(){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://pokeapi.co/api/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        InterfacePokemon inter = retrofit.create(InterfacePokemon.class);
        Call<Pokedex> servicio = inter.obtenerPokedex(151);
        servicio.enqueue(new Callback<Pokedex>() {
            @Override
            public void onResponse(Call<Pokedex> call, Response<Pokedex> response) {
                switch (response.code()){
                    case 200:
                        Pokedex pokedex = response.body();
                        pokelista = pokedex.results;
                        Pokedex_Adaptador pokedex_adaptador = new Pokedex_Adaptador(MainActivity.this,R.layout.item_pokedex,pokedex.results);
                        recyclerView.setAdapter(pokedex_adaptador);
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        break;
                }
            }

            @Override
            public void onFailure(Call<Pokedex> call, Throwable t) {

            }
        });
    }
}

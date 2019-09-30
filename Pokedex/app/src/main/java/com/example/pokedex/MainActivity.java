package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.pokedex.Adaptadores.AdaptadorPokedex;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycler_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler_view = findViewById(R.id.recycler_view);
        CargarPokedex();

    }

    void CargarPokedex(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        InterfazPokemon ip = retrofit.create(InterfazPokemon.class);
        Call<Pokedex> servicio = ip.obtenerPokedex(151);
        servicio.enqueue(new Callback<Pokedex>() {
            @Override
            public void onResponse(Call<Pokedex> call, Response<Pokedex> response) {
                switch (response.code()){
                    case 200:
                        Pokedex pokedex = response.body();
                        AdaptadorPokedex adaptadorPokedex =
                                new AdaptadorPokedex(MainActivity.this, R.layout.item_pokedex,pokedex.results);
                        recycler_view.setAdapter(adaptadorPokedex);
                        recycler_view.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        break;
                }
            }

            @Override
            public void onFailure(Call<Pokedex> call, Throwable t) {

            }
        });


    }
}

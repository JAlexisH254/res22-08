package com.example.tecsup.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Detalle_Pokemon extends AppCompatActivity {
    ImageView img;
    TextView nombre;
    LinearLayout ln;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle__pokemon);
        img = findViewById(R.id.poke_imagen);
        nombre = findViewById(R.id.poke_nombre);
        ln = findViewById(R.id.linear_poke);
        Intent intent = getIntent();
        CargarPokeDatos(intent.getStringExtra("codigo_pokemon"));
    }

    void CargarPokeDatos(String codigo){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        InterfacePokemon ip = retrofit.create(InterfacePokemon.class);
        Call<Pokemon> servicio = ip.obtenerPokemon(codigo);
        servicio.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                Pokemon p = response.body();
                nombre.setText(p.id +" - "+p.name);
                Glide.with(Detalle_Pokemon.this).load(p.sprites.front_default).into(img);

            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {

            }
        });

    }
}

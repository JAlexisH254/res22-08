package com.example.tecsup.repaso_pokeapi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    EditText codigo;
    Button btn_consulta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = findViewById(R.id.iv_imageView);
        codigo = findViewById(R.id.et_numero);
        btn_consulta = findViewById(R.id.boton);

        btn_consulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://pokeapi.co/api/v2/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Interface_pokemon ip = retrofit.create(Interface_pokemon.class);
                Call<Pokemon> llamada = ip.obtenerPokemon(Integer.parseInt(codigo.getText().toString()));
                llamada.enqueue(new Callback<Pokemon>() {
                    @Override
                    public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                        Pokemon poke = response.body();
                        Glide.with(MainActivity.this).load(poke.sprites.front_default).into(iv);
                        Toast.makeText(MainActivity.this,poke.sprites.back_default,Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Pokemon> call, Throwable t) {

                    }
                });
            }
        });


    }
}

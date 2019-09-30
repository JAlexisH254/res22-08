package com.example.apitienda2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.apitienda2.Adaptador.Genero_Adaptador;

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
        rv = findViewById(R.id.lista);

    }

    void ObtenerGnero(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://viveyupi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Interface_genero inter =retrofit.create(Interface_genero.class);
        Call<List<Genero>> servicio =inter.ObtenerGenero("JSON");
        servicio.enqueue(new Callback<List<Genero>>() {
            @Override
            public void onResponse(Call<List<Genero>> call, Response<List<Genero>> response) {
                List<Genero> genero = response.body();
                Genero_Adaptador genero_adaptador = new Genero_Adaptador(MainActivity.this,R.layout.item_categoria, (Genero) genero);
                rv.setAdapter(genero_adaptador);

            }

            @Override
            public void onFailure(Call<List<Genero>> call, Throwable t) {

            }
        });
    }
}

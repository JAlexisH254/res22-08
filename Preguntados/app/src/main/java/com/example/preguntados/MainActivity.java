package com.example.preguntados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ListView listPregun;
    List<Pregunta> p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listPregun = findViewById(R.id.listaPreguntas);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.23.8.225:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        servivios service = retrofit.create(servivios.class);
        Call<List<Pregunta>> preg = service.obtenerPregunta();
        preg.enqueue(new Callback<List<Pregunta>>() {
            @Override
            public void onResponse(Call<List<Pregunta>> call, Response<List<Pregunta>> response) {
                ArrayAdapter<Pregunta> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,p=response.body());
                listPregun.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Pregunta>> call, Throwable t) {
                Log.e("Error", t.toString());
            }
        });

        listPregun.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,RespuestaActivity.class);
                intent.putExtra("id",p.get(position).id);
                startActivity(intent);
            }
        });
    }
}

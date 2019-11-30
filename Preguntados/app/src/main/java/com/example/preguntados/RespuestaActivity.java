package com.example.preguntados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RespuestaActivity extends AppCompatActivity {
    ListView listResp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respuesta);
        listResp = findViewById(R.id.listResp);

        Bundle id = getIntent().getExtras();
        int idresp = id.getInt("id");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.23.8.225:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        servivios service = retrofit.create(servivios.class);
        Call<List<Respuesta>> rest = service.obtenerRespuesta(idresp);
        rest.enqueue(new Callback<List<Respuesta>>() {
            @Override
            public void onResponse(Call<List<Respuesta>> call, Response<List<Respuesta>> response) {
                ArrayAdapter<Respuesta> adapter = new ArrayAdapter<>(RespuestaActivity.this, android.R.layout.simple_list_item_1,response.body());
                listResp.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Respuesta>> call, Throwable t) {
                Log.e("Error", t.toString());
            }
        });
    }
}

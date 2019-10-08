package com.example.tecsup.ventas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lista_pedidos);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.23.8.85/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ServicioVentas servicioVentas = retrofit.create(ServicioVentas.class);
        Call<Ventas> llamada = servicioVentas.obtenerVentas();
        llamada.enqueue(new Callback<Ventas>() {
            @Override
            public void onResponse(Call<Ventas> call, Response<Ventas> response) {
                //Toast.makeText(MainActivity.this,response.body().getClientes()[0].getNombres(),Toast.LENGTH_LONG).show();
                AdaptadorVentas adapter = new AdaptadorVentas(MainActivity.this,R.layout.pedido_item,response.body().getPedidos(),response.body().getClientes());
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Ventas> call, Throwable t) {
                Log.e("ErrorServicios",t.toString());
            }
        });
    }
}

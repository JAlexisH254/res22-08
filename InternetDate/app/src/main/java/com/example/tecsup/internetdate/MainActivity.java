package com.example.tecsup.internetdate;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    JSONArray libros;
    Button buscar;
    EditText busqueda;

    List<String> titulos;
    ArrayAdapter<String> arrayAdapter;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buscar = findViewById(R.id.buscar);
        busqueda = findViewById(R.id.termino);
        lv = findViewById(R.id.lista);

        titulos = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_activated_1,titulos);
        lv.setAdapter(arrayAdapter);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager c = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo info = c.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

                if (info == null){
                    Toast.makeText(MainActivity.this, "Active wifi",Toast.LENGTH_SHORT).show();
                }else if (!info.isConnected()){
                    Toast.makeText(MainActivity.this, "Error, no tiene internet",Toast.LENGTH_SHORT).show();
                }

                final String BASE_URL =  "https://www.googleapis.com/books/v1/volumes?";
                final String QUERY_PARAM = "q";
                final String MAX_RESULTS = "maxResults";
                final String PRINT_TYPE = "printType";

                Uri builtURI = Uri.parse(BASE_URL).buildUpon()
                        .appendQueryParameter(QUERY_PARAM, busqueda.getText().toString())
                        .appendQueryParameter(MAX_RESULTS, "10")
                        .appendQueryParameter(PRINT_TYPE, "books")
                        .build();
                try{
                    URL  requestURL = new URL(builtURI.toString());
                    TastCargarLibros task = new TastCargarLibros(MainActivity.this);
                    task.execute(requestURL);

                }catch (MalformedURLException e){
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public void LlenarLibros(JSONArray i){
        libros = i;
        for (int a = 0;a<i.length();a++){
            String titulo = null;
            try {
                titulo = i.getJSONObject(a).getJSONObject("volumeInfo").getString("title");
                titulos.add(titulo);
            } catch (JSONException e) {}
            Toast.makeText(this,titulo,Toast.LENGTH_SHORT).show();

        }
        arrayAdapter.notifyDataSetChanged();
    }
}

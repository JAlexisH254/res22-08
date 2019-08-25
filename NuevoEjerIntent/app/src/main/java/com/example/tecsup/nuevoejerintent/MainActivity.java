package com.example.tecsup.nuevoejerintent;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    EditText et_dni;
    Button btn_buscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_dni = findViewById(R.id.et_dni);
        btn_buscar = findViewById(R.id.btn_buscar);

        btn_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Pantalla2.class);
                intent.putExtra("nombre",Funxion_Dni(String.valueOf(et_dni.getText().toString())));

                startActivity(intent);
            }
        });


    }

    public String Funxion_Dni(String dni){
        String resultado;
        try {
            URL url = new URL("http://aplicaciones007.jne.gob.pe/srop_publico/Consulta/Afiliado/GetNombresCiudadano?DNI="+dni);
            URLConnection con = null;

            con = url.openConnection();

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            BufferedReader r = new BufferedReader(new InputStreamReader(con.getInputStream(), "ISO-8859-1"));
            StringBuilder sb = new StringBuilder();
            try {
                String s;
                while ((s = r.readLine()) != null){
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                r.close();
            }
            resultado = sb.toString();
            return resultado;

        }catch (IOException ex){
            return resultado = "no se encontro";
        }
    }
}



package com.example.tecsup.trabajointents;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Bienvenida extends AppCompatActivity {
    TextView txt_respuesta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);
        txt_respuesta = findViewById(R.id.txt_respuesta);

        Intent intent = new Intent();
        String nombre = intent.getStringExtra("nombre");
        txt_respuesta.setText(nombre);


    }
}

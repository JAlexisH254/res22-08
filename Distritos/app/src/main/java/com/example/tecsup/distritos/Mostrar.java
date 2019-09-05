package com.example.tecsup.distritos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Mostrar extends AppCompatActivity {
    TextView txt_dni,txt_provincia,txt_distrito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        txt_dni = findViewById(R.id.txt_dni);
        txt_provincia = findViewById(R.id.txt_provincia);
        txt_distrito = findViewById(R.id.txt_distrito);

        Intent intent = getIntent();
        String dni = intent.getStringExtra("dni");
        String provincia = intent.getStringExtra("provincia");
        String distrito = intent.getStringExtra("distrito");

        txt_dni.setText(dni);
        txt_provincia.setText(provincia);
        txt_distrito.setText(distrito);
    }
}

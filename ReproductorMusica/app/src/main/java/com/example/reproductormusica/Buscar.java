package com.example.reproductormusica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Buscar extends AppCompatActivity {
    EditText et_buscar;
    RecyclerView rv_genero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        et_buscar = findViewById(R.id.et_buscar);
        rv_genero = findViewById(R.id.rv_genero);

        et_buscar.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                et_buscar.setBackgroundColor(Color.parseColor("#6D6D6D"));
                et_buscar.setHintTextColor(Color.parseColor("#FFFFFF"));
            }
        });


    }
}

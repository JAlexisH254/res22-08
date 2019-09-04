package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et_buscar;
    RecyclerView rv_genero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_buscar = findViewById(R.id.et_buscar);
        rv_genero = findViewById(R.id.rv_genero);



        et_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_buscar.setFocusableInTouchMode(true);
                et_buscar.setBackgroundColor(Color.parseColor("#6D6D6D"));
                et_buscar.setHintTextColor(Color.parseColor("#FFFFFF"));
                TextView mensaje = new TextView(getApplicationContext());
                mensaje.setText("hola mundo");

            }
        });
    }
}

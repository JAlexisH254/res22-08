package com.example.tecsup.distritos;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView txt_dni;
    Spinner spinner,spinner2;
    Button btn_enviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner_1);
        spinner2 = findViewById(R.id.spinner_2);
        btn_enviar = findViewById(R.id.btn_enviar);
        txt_dni = findViewById(R.id.txt_dni);

        String[] provincias = getResources().getStringArray(R.array.provincias);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,provincias);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                position = position;
                String selection = parent.getItemAtPosition(position).toString();
                switch (selection){
                    case "Arequipa":
                        String[] distritos = getResources().getStringArray(R.array.Arequipa);
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item, distritos);
                        spinner2.setAdapter(adapter);
                        break;
                    case "Camana":
                        String[] distritos1 = getResources().getStringArray(R.array.Camana);
                        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item, distritos1);
                        spinner2.setAdapter(adapter1);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Mostrar.class)
                        .putExtra("dni",txt_dni.getText().toString())
                        .putExtra("distrito",spinner.getItemAtPosition(spinner.getSelectedItemPosition()).toString())
                        .putExtra("provincia",spinner2.getItemAtPosition(spinner2.getSelectedItemPosition()).toString());
                startActivity(intent);
            }
        });


    }
}

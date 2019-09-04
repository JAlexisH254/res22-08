package com.example.tecsup.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner  = findViewById(R.id.spinner_0);

        List<Persona> datos = new ArrayList<>();
        datos.add(new Persona("1234567","juan",R.drawable.ic_battery_30_black_24dp));
        datos.add(new Persona("1234567","juan",R.drawable.ic_battery_50_black_24dp));

        String[] datos2 = getResources().getStringArray(R.array.aves);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,datos2);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.item_spinner,datos2);

        AdaptadoSpinner adapter = new AdaptadoSpinner(this,datos,R.layout.item_spinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}

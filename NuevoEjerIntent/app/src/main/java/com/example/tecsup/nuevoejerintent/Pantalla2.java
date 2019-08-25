package com.example.tecsup.nuevoejerintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {
    TextView txt_n;
    TextView txt_ap;
    TextView txt_am;
    String[] part;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        txt_n =findViewById(R.id.txt_n);
        txt_ap = findViewById(R.id.txt_ap);
        txt_am = findViewById(R.id.txt_am);

        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        part = nombre.split("[|]",3);

        txt_n.setText(part[2]);
        txt_ap.setText(part[0]);
        txt_am.setText(part[1]);
    }
}

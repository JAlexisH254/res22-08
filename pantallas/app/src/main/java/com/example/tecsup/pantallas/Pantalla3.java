package com.example.tecsup.pantallas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Pantalla3 extends AppCompatActivity {
    Button btn;
    LinearLayout line;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla3);
        btn = findViewById(R.id.btn_contador);
        line = findViewById(R.id.linearLayout2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView a = new TextView(getApplicationContext());
                a.setText("Hola");
                line.addView(a);
                Toast.makeText(Pantalla3.this, "holas",Toast.LENGTH_LONG).show();
            }
        });
    }
}

package com.example.tecsup.intent02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class pantalla2 extends AppCompatActivity {
    Button btn_sig;
    Button btn_ant;
    TextView txt_men;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        btn_sig = findViewById(R.id.btn_sig02);
        btn_ant = findViewById(R.id.btn_ant1);
        txt_men = findViewById(R.id.txt_mensaje02);

        Intent intent = getIntent();
        txt_men.setText(intent.getStringExtra("mensaje"));

        btn_ant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pantalla2.this, MainActivity.class)
                        .putExtra("mensaje", txt_men.getText().toString());
                startActivity(intent);
            }
        });

        btn_sig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pantalla2.this, pantalla3.class);
                startActivity(intent);
            }
        });
    }
}

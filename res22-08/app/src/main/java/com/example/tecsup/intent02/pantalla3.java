package com.example.tecsup.intent02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class pantalla3 extends AppCompatActivity {
    Button btn_ant;
    Button btn_sig;
    TextView txt_men;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla3);
        btn_ant =findViewById(R.id.btn_ant2);
        btn_sig =findViewById(R.id.btm_sig03);
        txt_men = findViewById(R.id.txt_mensaje3);

        Intent intent = getIntent();
        txt_men.setText(intent.getStringExtra("mensaje"));

        btn_ant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pantalla3.this,pantalla2.class)
                        .putExtra("mensaje", txt_men.getText().toString());
                startActivity(intent);

            }
        });

        btn_sig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pantalla3.this, pantalla4.class);
                startActivity(intent);
            }
        });
    }
}

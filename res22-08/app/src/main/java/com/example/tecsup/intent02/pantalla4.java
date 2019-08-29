package com.example.tecsup.intent02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class pantalla4 extends AppCompatActivity {
    Button btn_ant;
    EditText et_mensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla4);
        btn_ant = findViewById(R.id.btn_ant03);
        et_mensaje = findViewById(R.id.et_mensaje);

        btn_ant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pantalla4.this, pantalla3.class)
                        .putExtra("mensaje",et_mensaje.getText().toString());
                startActivity(intent);
            }
        });
    }
}

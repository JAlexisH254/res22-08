package com.example.intent02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class pantalla04 extends AppCompatActivity {
    Button btn_anterior;
    EditText et_ingresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla04);
        btn_anterior = findViewById(R.id.btn_back03);
        et_ingresar = findViewById(R.id.et_ingresar);

        btn_anterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pantalla04.this, pantalla03.class);
                intent.putExtra("nombre", et_ingresar.getText().toString());
                startActivity(intent);
            }
        });
    }
}

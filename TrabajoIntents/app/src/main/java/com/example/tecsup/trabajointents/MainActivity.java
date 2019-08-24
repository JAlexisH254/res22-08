package com.example.tecsup.trabajointents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn_ingresar;
    EditText et_nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_ingresar = findViewById(R.id.btn_ingresar);
        et_nombre = findViewById(R.id.et_nombre);

        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Bienvenida.class);
                intent.putExtra("nombre",et_nombre.getText());
                startActivity(intent);
            }
        });
    }
}

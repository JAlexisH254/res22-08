package com.example.tecsup.botonprueba;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class pantalla1 extends AppCompatActivity {
    TextView txt_nombre;
    TextView txt_edad;
    Button btn_regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);
        txt_nombre = findViewById(R.id.txt_nombre);
        txt_edad = findViewById(R.id.txt_edad);
        btn_regresar = findViewById(R.id.btn_regresar);

        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        int edad = intent.getIntExtra("edad", 0);

        txt_nombre.setText(nombre);
        txt_edad.setText(String.valueOf(edad));

        btn_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("respuesta","regreso de otra pantalla");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }


}

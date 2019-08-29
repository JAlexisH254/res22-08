package com.example.tecsup.pantallas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Pantalla6 extends AppCompatActivity {
    Button[] btns_numeros = new Button[10];
    TextView txt_display;
    String display = "";
    Button sumar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla6);
        txt_display = findViewById(R.id.txt_display);

        AsignarBoton();
        AsignarEvento();


    }

    void AsignarBoton(){
        btns_numeros[0] = findViewById(R.id.btn_0);
        btns_numeros[1] = findViewById(R.id.btn_1);
        btns_numeros[2] = findViewById(R.id.btn_2);
        btns_numeros[3] = findViewById(R.id.btn_3);
        btns_numeros[4] = findViewById(R.id.btn_4);
        btns_numeros[5] = findViewById(R.id.btn_5);
        btns_numeros[6] = findViewById(R.id.btn_6);
        btns_numeros[7] = findViewById(R.id.btn_7);
        btns_numeros[8] = findViewById(R.id.btn_8);
        btns_numeros[9] = findViewById(R.id.btn_9);
    }

    void AsignarEvento(){
        for (int i = 0;i < 10;i++){
            final int finalI = i;
            btns_numeros[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    display += finalI;
                    txt_display.setText(display);
                }
            });
        }
    }
}

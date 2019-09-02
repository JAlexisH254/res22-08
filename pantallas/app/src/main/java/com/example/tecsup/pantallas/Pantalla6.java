package com.example.tecsup.pantallas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Pantalla6 extends AppCompatActivity {
    Button[] btns_numeros = new Button[10];
    Button[] btns_operacion = new Button[4];
    TextView display;
    String str_display = "";
    Button sumar;
    int operando1 = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla6);
        display = findViewById(R.id.txt_display);
        igual = finish(R.id.btn_igual);
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

        btns_operaciones[0]
    }

    void AsignarEvento(){
        for (int i = 0;i < 10;i++){
            final int finalI = i;
            btns_numeros[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str_display += finalI;
                    display.setText(str_display);
                }
            });
        }

        for (int i = 0;i < 4;i++){
            final int finalI = i;
            btns_operacion[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EjercutarOperacion();
                    operando1 = Integer.parseInt(str_display);
                    operacion = finalI;
                    str_display = "";
                }
            });
        }

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EjercutarOperacion();
            }
        });
    }

    void EjercutarOperacion(){
        if(operando1 != 0 && !str_display.equal("")){
            if (opracion == 0){
                operando1 = operando1 + Integer.parseInt(str_display);
            }else if (opracion == 1){
                operando1 = operando1 - Integer.parseInt(str_display);
            }else if (opracion == 2){
                operando1 = operando1 * Integer.parseInt(str_display);
            }else if (opracion == 3){
                operando1 = operando1 / Integer.parseInt(str_display);
            }
            str_display = String.valueOf(operando1);
            display.setText(str_display);
            opracion = 0;
        }
    }
}

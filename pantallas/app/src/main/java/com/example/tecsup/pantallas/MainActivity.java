package com.example.tecsup.pantallas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn01, btn02, btn03, btn04, btn05, btn06;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn01 = findViewById(R.id.btn_ptl1);
        btn02 = findViewById(R.id.btn_ptl2);
        btn03 = findViewById(R.id.btn_ptl3);
        btn04 = findViewById(R.id.btn_ptl4);
        btn05 = findViewById(R.id.btn_ptl5);
        btn06 = findViewById(R.id.btn_ptl6);

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainActivity.this, pantalla1.class);
                startActivity(a);
            }
        });

        /*btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainActivity.this, pantalla2.class);
                startActivity(a);
            }
        });*/

        btn03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainActivity.this, Pantalla3.class);
                startActivity(a);
            }
        });

        btn04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainActivity.this, Pantalla4.class);
                startActivity(a);
            }
        });

        btn05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainActivity.this, pantalla5.class);
                startActivity(a);
            }
        });

        btn06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainActivity.this, Pantalla6.class);
                startActivity(a);
            }
        });
    }
}

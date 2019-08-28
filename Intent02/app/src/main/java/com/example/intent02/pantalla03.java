package com.example.intent02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class pantalla03 extends AppCompatActivity {
    TextView txt_n3;
    Button btn_back2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla03);
        txt_n3 =findViewById(R.id.txt_n3);
        btn_back2 = findViewById(R.id.btn_back02);

        Intent intent = getIntent();
        txt_n3.setText(intent.getStringExtra("nombre"));

        btn_back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}

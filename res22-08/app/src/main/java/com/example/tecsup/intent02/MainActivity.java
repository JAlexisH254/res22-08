package com.example.tecsup.intent02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn_sig01;
    TextView txt_men;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_sig01 = findViewById(R.id.btn_sig1);
        txt_men =findViewById(R.id.txt_mensaje01);

        Intent intent = getIntent();
        txt_men.setText(intent.getStringExtra("mensaje"));

        btn_sig01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, pantalla2.class);
                startActivity(intent);
            }
        });
    }
}

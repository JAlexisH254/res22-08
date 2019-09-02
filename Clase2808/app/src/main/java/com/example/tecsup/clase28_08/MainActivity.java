package com.example.tecsup.clase28_08;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);

        try {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("Error app","Error en elboton");

                }
            });
        }catch (Exception e) {
            Log.e("Error api", e.toString());
        }finally {
            Log.d("Debug app", "Llego al finally");
        }
    }
}

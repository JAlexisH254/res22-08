package com.example.tecsup.thread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton = findViewById(R.id.button);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    URL url = new URL("https://i.blogs.es/2b7c9a/moon-colors/450_1000.jpg");
                    new MyAsyncTask(boton,MainActivity.this).execute(url);
                }catch (MalformedURLException e){
                    e.printStackTrace();
                }

                StringListLoader s = new StringListLoader(MainActivity.this);
                s.loadInBackground();
            }
        });
    }
}

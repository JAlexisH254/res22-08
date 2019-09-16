package com.example.new_tarea_face;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageView foto;
    TextView nombre;
    Button publicar;
    TextView publicacion;
    Button camara;
    ImageView imagen;

    ListView lv;
    List<publicacion> datos;

    Date date;
    DateFormat hourFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        foto = findViewById(R.id.iv_foto);
        nombre = findViewById(R.id.tv_nombre);
        publicar = findViewById(R.id.btn_publicar);
        publicacion = findViewById(R.id.tv_publicacion);
        camara = findViewById(R.id.btn_foto);
        imagen = findViewById(R.id.iv_imagen);
        lv = findViewById(R.id.lista);
        datos = new ArrayList<>();

        date = new Date();
        hourFormat = new SimpleDateFormat("HH:mm:ss");



        camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(intent.resolveActivity(getPackageManager())!= null){
                    startActivityForResult(intent,1);
                }
            }
        });

        publicar.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                datos.add(new publicacion(      foto.getDrawable(),
                                                nombre.getText().toString(),
                                                hourFormat.format(date),
                                                publicacion.getText().toString(),
                                                imagen.getDrawable()));

                adaptador_publicacion dapter = new adaptador_publicacion(MainActivity.this, R.layout.vista_publicacion,datos);
                lv.setAdapter(dapter);

                publicacion.setText("");
                imagen.setImageDrawable(null);
            }

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK){
            Bitmap ima =  data.getParcelableExtra("data");
            imagen.setImageBitmap(ima);
        }

    }
}

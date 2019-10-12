package com.example.tecsup.tiendafragment;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentListCategoria.CallBackCAtegoria {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void CategoriaSeleccionada(int codigo) {
        Toast.makeText(this,"cod +"+codigo,Toast.LENGTH_LONG).show();
    }
}

package com.example.tecsup.repasofragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;
    int color = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button =findViewById(R.id.CambiaFragment);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();

        FragmentRosado fr = new FragmentRosado();
        fragmentTransaction.add(R.id.fragment_container,fr);
        fragmentTransaction.commit();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CambiarFragment();
                color++;

            }
        });
    }

    void CambiarFragment(){
        Fragment newFragment = new FragmentView();
        if(color%2==0)
            newFragment = new FragmentRosado();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}

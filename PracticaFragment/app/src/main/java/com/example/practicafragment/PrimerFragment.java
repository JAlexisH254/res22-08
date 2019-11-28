package com.example.practicafragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PrimerFragment extends Fragment {

    TextView tv;
    SegundoFragment f2;
    TercerFragment f3;
    public PrimerFragment(SegundoFragment F2, TercerFragment f3) {
        // Required empty public constructor
        this.f2 = f2;
        this.f3 = f3;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_primer, container, false);
        Button b = v.findViewById(R.id.button1);
        tv = v.findViewById(R.id.textView1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f2.CambiarTexto("fragment : PRECIONADO");
                f3.CambiarTexto("fragment : PRECIONADO");
            }
        });
        return v;
    }
    void CambiarTexto(String texto){
        tv.setText(texto);
    }
}

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
public class TercerFragment extends Fragment {

    TextView tv;
    public TercerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tercer, container, false);
        Button b = v.findViewById(R.id.button1);
        tv = v.findViewById(R.id.textView1);
        return v;
    }
    void CambiarTexto(String texto){
        tv.setText(texto);
    }

}

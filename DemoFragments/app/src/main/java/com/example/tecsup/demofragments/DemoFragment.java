package com.example.tecsup.demofragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DemoFragment extends Fragment {
    int contador= 0;
    TextView tv;
    Button b;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_demo, container, false);
        tv = v.findViewById(R.id.textView);
        b = v.findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador++;
                tv.setText(String.valueOf(contador));
            }
        });
        return v;
    }
    public  void Aumentar(){
        contador++;
        tv.setText(String.valueOf(contador));
    }
}

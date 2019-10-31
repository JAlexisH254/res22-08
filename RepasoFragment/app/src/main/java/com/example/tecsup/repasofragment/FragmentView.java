package com.example.tecsup.repasofragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentView extends Fragment {

    RecyclerView recyclerView;
    public FragmentView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_view, container, false);
        // Inflate the layout for this fragment
        recyclerView = v.findViewById(R.id.lista);
        List<String> nombres =new ArrayList<>();
        nombres.add("pepito");
        nombres.add("pepito2");
        AdaptadorNombres adaptadorNombres = new AdaptadorNombres(getContext(),R.layout.item_layout, nombres);
        recyclerView.setAdapter(adaptadorNombres);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return v;
    }

}

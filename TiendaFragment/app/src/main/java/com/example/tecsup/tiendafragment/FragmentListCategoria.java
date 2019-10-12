package com.example.tecsup.tiendafragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tecsup.tiendafragment.Adaptadores.AdaptadorCategoria;
import com.example.tecsup.tiendafragment.Adaptadores.CategoriaHolder;
import com.example.tecsup.tiendafragment.Entidades.Categoria;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListCategoria extends Fragment implements CategoriaHolder.CategoriCallBack {
    RecyclerView recyclerView;
    CallBackCAtegoria callBackCAtegoria;

    public FragmentListCategoria() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_list_categoria, container, false);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://viveyupi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ServicioTienda s = retrofit.create(ServicioTienda.class);
        Call<List<Categoria>> call = s.ObtenerCategoriaPorNivel(1);

        recyclerView=view.findViewById(R.id.rv_categoria);
        call.enqueue(new Callback<List<Categoria>>() {
            @Override
            public void onResponse(Call<List<Categoria>> call, Response<List<Categoria>> response) {
                AdaptadorCategoria adapter =  new AdaptadorCategoria(getContext(),  FragmentListCategoria.this,response.body());
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
            }

            @Override
            public void onFailure(Call<List<Categoria>> call, Throwable t) {

            }
        });
        return view;
    }

    @Override
    public void CategoriaSeleccionada(int id) {
        callBackCAtegoria.CategoriaSeleccionada(id);
    }

    public interface CallBackCAtegoria{
        void CategoriaSeleccionada(int codigo);
    }
}

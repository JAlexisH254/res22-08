package com.example.tecsup.tiendafragment;

import com.example.tecsup.tiendafragment.Entidades.Categoria;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ServicioTienda {
    @GET("categorias/nivel/{nivel}/")
    Call<List<Categoria>> ObtenerCategoriaPorNivel(@Path("nivel")int nivel) ;

    @GET("categorias/padre/{padre}/")
    Call<List<Categoria>> ObtenerCategoriaPorPadre(@Path("padre")int padre) ;
}

package com.example.apitienda2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Interface_genero {

    @GET("categorias/")
    Call<List<Genero>> ObtenerGenero(@Query("format") String genero) ;
}

package com.example.tienda3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Interface_Categoria2 {
    @GET("categorias/padre/{id}/?format=json")
    Call<List<Categoria>> listCategorias2(@Path("id") int id);
}

package com.example.tienda3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Interface_Categoria {
    @GET("categorias/nivel/{nivel}/?format=json")
    Call<List<Categoria>> listCategorias(@Path("nivel") int nivel);
}

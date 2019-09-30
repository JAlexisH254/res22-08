package com.example.tienda3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Interface_Categoria {
    @GET("categorias/")
    Call<List<Categoria>> listCategorias(@Query("format") String format);
}

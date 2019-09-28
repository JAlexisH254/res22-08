package com.example.tecsup.retrofit;



import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InterfacePokemon {
    @GET("pokemon/")
    Call<Pokedex> obtenerPokedex(@Query("limit") int cantidad);
}

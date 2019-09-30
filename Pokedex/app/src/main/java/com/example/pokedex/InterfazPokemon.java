package com.example.pokedex;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InterfazPokemon {

    @GET("pokemon/")
    Call<Pokedex> obtenerPokedex(@Query("limit") int cantidad);
}

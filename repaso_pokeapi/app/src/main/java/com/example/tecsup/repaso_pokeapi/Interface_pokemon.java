package com.example.tecsup.repaso_pokeapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Interface_pokemon {
    @GET("pokemon/{id}/")
    Call<Pokemon> obtenerPokemon(@Path("id") int id);
}

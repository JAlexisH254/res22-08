package com.example.tecsup.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface InterfaceGitHub {
    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);

    @GET("pokemon/{pokemon}/")
    Call<List<Pokemon>> listPokemon(@Path("pokemon") String pokemon);
}

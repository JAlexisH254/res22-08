package com.example.preguntados;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface servivios {

    @GET("pregunta/")
    Call<List<Pregunta>> obtenerPregunta();

    @GET("respuesta/{id}")
    Call<List<Respuesta>> obtenerRespuesta(@Path("id") int id);
}

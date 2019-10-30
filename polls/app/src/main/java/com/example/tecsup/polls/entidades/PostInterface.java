package com.example.tecsup.polls.entidades;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PostInterface {
    @GET("questions/")
    Call<List<Question>> ListarPreguntas();

    @FormUrlEncoded
    @POST("questions/")
    Call<Question> CrearPregunta(@Field("question_text") String question_text);

    @FormUrlEncoded
    @PUT("questions/<id>/")
    Call<Question> ActualizarPregunta(@Path("id") int id, @Field("question_text") String question_text);

    @FormUrlEncoded
    @DELETE("questions/<id>/")
    Call<Question> EliminarPregunta(@Path("id") int id);


}

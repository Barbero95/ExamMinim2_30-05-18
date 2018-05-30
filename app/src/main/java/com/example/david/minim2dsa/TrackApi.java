package com.example.david.minim2dsa;

import java.util.List;
import java.util.Queue;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TrackApi {

    @GET("/books")
    Call<List<Libro>> listaLibros();

    @GET("/books/{id}")
    Call<Libroinfo> infoLibro (@Path("id") String nombre);

    @POST("/books")
    Call<Response> realizarOperacion(@Body Libroinfo libroNuevo);

}

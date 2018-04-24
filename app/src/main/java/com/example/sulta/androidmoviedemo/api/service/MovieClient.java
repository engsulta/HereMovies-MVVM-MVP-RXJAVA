package com.example.sulta.androidmoviedemo.api.service;

import com.example.sulta.androidmoviedemo.api.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface MovieClient {
    static String BASE_URL = "http://api.androidhive.info/json/";

    @GET("movies.json")
    Call<List<Movie>> getAllMovies();
}

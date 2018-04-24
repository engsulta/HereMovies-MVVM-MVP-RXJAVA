package com.example.sulta.androidmoviedemo.ui.main;

import com.example.sulta.androidmoviedemo.api.model.Movie;
import com.example.sulta.androidmoviedemo.api.service.MovieClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sulta on 4/15/2018.
 */

public class MainPresenter implements MainContract.Presenter {
    List<Movie> movies;
    MainContract.View viewRef;
    MainPresenter(MainContract.View viewref){
        this.viewRef=viewref;
    }
    @Override
    public void subscripToRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MovieClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MovieClient api = retrofit.create(MovieClient.class);
        Call<List<Movie>> call = api.getAllMovies();
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
              movies = response.body();
              // i should subscribe here
                viewRef.updateUi(movies);
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                movies=null;
                // i should subscribe here
                viewRef.updateUi(movies);

            }
        });
    }
}

package com.example.sulta.androidmoviedemo.ui.main;

import com.example.sulta.androidmoviedemo.api.model.Movie;

import java.util.List;

/**
 * Created by sulta on 4/15/2018.
 */

public interface MainContract {
    interface View {
        void updateUi(List <Movie> movies);
    }
    interface Presenter
    {
        void subscripToRetrofit();

    }

}

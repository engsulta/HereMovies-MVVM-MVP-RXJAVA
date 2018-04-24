package com.example.sulta.androidmoviedemo.api.model;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie {
    @SerializedName("title")
    private String movieTitle;

    @SerializedName("image")
    private String moviePosterURL;

    @SerializedName("rating")
    private double movieRating;

    @SerializedName("releaseYear")
    private int movieReleaseYear;

    @SerializedName("genre")
    private List<String> movieGenre;

    public Movie() {
    }
    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMoviePosterURL() {
        return moviePosterURL;
    }

    public void setMoviePosterURL(String moviePosterURL) {
        this.moviePosterURL = moviePosterURL;
    }

    public double getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(double movieRating) {
        this.movieRating = movieRating;
    }

    public int getMovieReleaseYear() {
        return movieReleaseYear;
    }

    public void setMovieReleaseYear(int movieReleaseYear) {
        this.movieReleaseYear = movieReleaseYear;
    }

    public String getMovieGenre() {
        StringBuilder builder = new StringBuilder();
        Log.i("MovieDemo", "getMovieGenre: "+this.movieGenre.size());
        for (String type : this.movieGenre) {

            builder.append(type.concat(" "));

        }
        return builder.toString();
    }

    public void setMovieGenre(List<String> movieGenre) {
        this.movieGenre = movieGenre;
    }
}


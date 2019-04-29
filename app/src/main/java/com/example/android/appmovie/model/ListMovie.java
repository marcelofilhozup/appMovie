package com.example.android.appmovie.model;

import java.util.List;

public class ListMovie {

    private  List<Movie> results;

    public ListMovie(List<Movie> movie) {
        this.results = movie;
    }

    public List<Movie> getMovie() {
        return results;
    }

    public void setMovie(List<Movie> result){

        this.results = result;

    }
}

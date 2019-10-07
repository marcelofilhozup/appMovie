package com.example.android.appmovie.model;

import java.util.List;

public class ListMovie {

    private  List<Movie> Search;

    public ListMovie(List<Movie> movie) {
        this.Search = movie;
    }

    public List<Movie> getMovie() {
        return Search;
    }

    public void setMovie(List<Movie> search){

        this.Search = search;

    }
}

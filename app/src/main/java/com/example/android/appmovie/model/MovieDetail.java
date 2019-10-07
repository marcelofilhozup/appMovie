package com.example.android.appmovie.model;

import java.util.ArrayList;
import java.util.List;

public class MovieDetail {

    private String imdbID;
    private String poster_path;
    private String backdrop_path;
    private String voteAverage;
    private String voteCount;
    private String original_title;
    private String release_date;
    private List<String> genreNames = new ArrayList<>();
    private String runtime;
    private String overview;
    private Boolean favorit;
    private String price;
    private Boolean acquired;
    private List<String> directors;
    private List<String> writers;
    private List<String> countries;

    public String getId() {
        return imdbID;
    }

    public void setId(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getPosterId() {
        return poster_path;
    }

    public void setPosterId(String posterId) {
        this.poster_path = posterId;
    }

    public String getBannerId() {
        return backdrop_path;
    }

    public void setBannerId(String bannerId) {
        this.backdrop_path = bannerId;
    }

    public String getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(String voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(String voteCount) {
        this.voteCount = voteCount;
    }

    public String getTitle() {
        return original_title;
    }

    public void setTitle(String title) {
        this.original_title = title;
    }

    public String getYear() {
        return release_date;
    }

    public void setYear(String year) {
        this.release_date = year;
    }

    public List<String> getGenreNames() {
        return genreNames;
    }

    public void setGenreNames(List<String> genreNames) {
        this.genreNames = genreNames;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Boolean getFavorit() {
        return favorit;
    }

    public void setFavorit(Boolean favorit) {
        this.favorit = favorit;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Boolean getAcquired() {
        return acquired;
    }

    public void setAcquired(Boolean acquired) {
        this.acquired = acquired;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public void setDirectors(List<String> directors) {
        this.directors = directors;
    }

    public List<String> getWriters() {
        return writers;
    }

    public void setWriters(List<String> writers) {
        this.writers = writers;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }
}

package com.example.android.appmovie.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "movie_table")
public class Movie {

    @NonNull
    @PrimaryKey
    private String imdbID;

    public String getPoster() {
        return Poster;
    }

    public String getVote_average() {
        return vote_average;
    }

    private String Poster;
    private String bannerId;

    public void setPoster(String poster) {
        this.Poster = poster;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }


    private String vote_average;
    private String voteCount;
    private String Title;
    private String Year;
    private String runtime;
    private String overview;
    private Boolean favorit;
    private Float price;
    private Boolean acquired;

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }



    public void setPosterId(String posterId) {
        this.Poster = posterId;
    }

    public String getBannerId() {
        return bannerId;
    }

    public void setBannerId(String bannerId) {
        this.bannerId = bannerId;
    }



    public void setVoteAverage(String voteAverage) {
        this.vote_average = voteAverage;
    }

    public String getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(String voteCount) {
        this.voteCount = voteCount;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        this.Year = year;
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Boolean getAcquired() {
        return acquired;
    }

    public void setAcquired(Boolean acquired) {
        this.acquired = acquired;
    }



}

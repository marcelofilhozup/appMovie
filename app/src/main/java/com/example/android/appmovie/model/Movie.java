package com.example.android.appmovie.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "movie_table")
public class Movie {

    @NonNull
    @PrimaryKey
    private String id;

    public String getPoster_path() {
        return poster_path;
    }

    public String getVote_average() {
        return vote_average;
    }

    private String poster_path;
    private String bannerId;

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    private String vote_average;
    private String voteCount;
    private String title;
    private String release_date;
    private String runtime;
    private String overview;
    private Boolean favorit;
    private Float price;
    private Boolean acquired;

    public int getUserAverage() {
        return userAverage;
    }

    public void setUserAverage(int userAverage) {
        this.userAverage = userAverage;
    }

    private int userAverage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public void setPosterId(String posterId) {
        this.poster_path = posterId;
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
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setYear(String year) {
        this.release_date = year;
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

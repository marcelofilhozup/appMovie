package com.example.android.appmovie.connect;

import com.example.android.appmovie.model.ListMovie;
import com.example.android.appmovie.model.MovieDetail;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieService {



    @GET("search/movie")
    Call<ListMovie> getListMovie(@Query("query") String name);

    @GET("movie/{movie_id}/similar")
    Call<ListMovie> getListMovieDetail(@Path("movie_id") String movie_id);


    @GET("movie/{movie_id}")
    Call<MovieDetail> getDetailMovie(@Path("movie_id") String movie_id);

    @GET("users/{email}/favorits")
    Call<ListMovie> getFavoriteMovie(@Path("email") String email);
}

package com.example.android.appmovie.connect;

import com.example.android.appmovie.model.ListMovie;
import com.example.android.appmovie.model.MovieDetail;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieService {



    @GET("?")
    Call<ListMovie> getListMovie(@Query("s") String name,@Query("page") String page);

    @GET("movie/{movie_id}/similar")
    Call<ListMovie> getListMovieDetail(@Path("movie_id") String movie_id);

    @GET("?")
    Call<MovieDetail> getDetailMovie(@Query("i") String imdbID);

}

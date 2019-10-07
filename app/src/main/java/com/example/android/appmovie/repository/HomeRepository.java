package com.example.android.appmovie.repository;

import com.example.android.appmovie.Utility.CallBack;
import com.example.android.appmovie.model.ListMovie;
import com.example.android.appmovie.model.MovieDetail;

import javax.security.auth.callback.Callback;

public interface HomeRepository {


    void getMovieList(String name,String page, MovieListaCallBack callBack);

    interface MovieListaCallBack extends CallBack<ListMovie>{

    }

    void getMovieDetail(String id, MovieDetailCallBack callBack);

    interface MovieDetailCallBack extends CallBack<MovieDetail>{

    }
}

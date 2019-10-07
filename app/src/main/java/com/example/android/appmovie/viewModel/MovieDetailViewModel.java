package com.example.android.appmovie.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.android.appmovie.model.ListMovie;
import com.example.android.appmovie.model.MovieDetail;
import com.example.android.appmovie.repository.HomeRepositoryImpl;

public class MovieDetailViewModel extends AndroidViewModel {

    private HomeRepositoryImpl homeRepositoryImpl;
    private MutableLiveData<MovieDetail> movieDetail = new MutableLiveData<>();
    private MutableLiveData<ListMovie> listMovie = new MutableLiveData<>();

    public MovieDetailViewModel(@NonNull Application application) {
        super(application);
        this.homeRepositoryImpl = new HomeRepositoryImpl();
    }

    public void init(String id) {

//        homeRepositoryImpl.getMovieDetail(id).observeForever(new Observer<MovieDetail>() {
//            @Override
//            public void onChanged(@Nullable MovieDetail movieDetail) {
//                getMovieDetail().setValue(movieDetail);
//
//
//            }
//        });
    }

    public void initMovieList(String id) {
        homeRepositoryImpl.getMovieListDetail(id ).observeForever(new Observer<ListMovie>() {
            @Override
            public void onChanged(@Nullable ListMovie listMovie) {
                getListMovie().setValue(listMovie);
            }
        });
    }

    public MutableLiveData<MovieDetail> getMovieDetail() {
        return movieDetail;
    }

    public MutableLiveData<ListMovie> getListMovie() {
        return listMovie;
    }
}

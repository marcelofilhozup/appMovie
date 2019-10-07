package com.example.android.appmovie.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.android.appmovie.model.ListMovie;
import com.example.android.appmovie.repository.HomeRepositoryImpl;

public class SearchFragmentViewModel extends AndroidViewModel  {

    private HomeRepositoryImpl homeRepositoryImpl;
    private MutableLiveData<ListMovie> listMovie = new MutableLiveData<>();

    public SearchFragmentViewModel(@NonNull Application application) {
        super(application);

        this.homeRepositoryImpl = new HomeRepositoryImpl();

    }

//    public void init(String name, String page) {
//
//
//        homeRepositoryImpl.getMovieList(name,page).observeForever(new Observer<ListMovie>() {
//            @Override
//            public void onChanged(@Nullable ListMovie listMovie) {
//                getListMovie().setValue(listMovie);
//            }
//        });
//    }

    public void verify(){

    }

    public MutableLiveData<ListMovie> getListMovie() {
        return listMovie;
    }
}

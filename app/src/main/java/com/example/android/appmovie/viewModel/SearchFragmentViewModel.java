package com.example.android.appmovie.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.android.appmovie.model.ListMovie;
import com.example.android.appmovie.repository.HomeRepository;

public class SearchFragmentViewModel extends AndroidViewModel {

    private HomeRepository homeRepository;
    private MutableLiveData<ListMovie> listMovie = new MutableLiveData<>();

    public SearchFragmentViewModel(@NonNull Application application) {
        super(application);

        this.homeRepository = new HomeRepository();

    }

    public void init(String name, String page) {

       ;
        homeRepository.getMovieList(name,page).observeForever(new Observer<ListMovie>() {
            @Override
            public void onChanged(@Nullable ListMovie listMovie) {
                getListMovie().setValue(listMovie);
            }
        });
    }

    public MutableLiveData<ListMovie> getListMovie() {
        return listMovie;
    }
}

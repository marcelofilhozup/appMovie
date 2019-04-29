package com.example.android.appmovie.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.android.appmovie.model.ListMovie;
import com.example.android.appmovie.model.Movie;
import com.example.android.appmovie.repository.RoomRepository;

import java.util.List;

public class RoomViewModel extends AndroidViewModel {

    private RoomRepository repository;

    private LiveData<List<Movie>> allMovie;
    private LiveData<Integer> listSize;

    public RoomViewModel(Application application){
        super(application);
        repository = new RoomRepository (application);
        allMovie = repository.getAllCompromissos();

    }

    public LiveData<List<Movie>> getAllMovie() { return allMovie; }



    public void insert(Movie movie) { repository.insert(movie); }
    public void delete(String idMovie) {repository.deleteMovie(idMovie);}
}

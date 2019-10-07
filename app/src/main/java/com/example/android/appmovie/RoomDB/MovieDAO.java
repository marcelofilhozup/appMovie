package com.example.android.appmovie.RoomDB;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.android.appmovie.model.ListMovie;
import com.example.android.appmovie.model.Movie;

import java.util.List;

@Dao
public interface MovieDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert (Movie movie);

    @Query("SELECT * from movie_table ORDER BY vote_average ASC")
    LiveData<List<Movie>> getAllCompromissos();

    @Query("DELETE FROM movie_table WHERE id = :idMovie")
    void deleteMovie(String idMovie);
}

package com.example.android.appmovie.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.RoomDatabase;
import android.os.AsyncTask;

import com.example.android.appmovie.RoomDB.FavoriteMovieDataBase;
import com.example.android.appmovie.RoomDB.MovieDAO;
import com.example.android.appmovie.model.ListMovie;
import com.example.android.appmovie.model.Movie;

import java.util.List;

public class RoomRepository {

    private MovieDAO movieDAO;
    private LiveData<List<Movie>> allMovie;


   public RoomRepository(Application application){
        FavoriteMovieDataBase db = FavoriteMovieDataBase.getDatabase(application);

        movieDAO = db.movieDAO();
        allMovie = movieDAO.getAllCompromissos();

    }

    public LiveData<List<Movie>> getAllCompromissos() {

        System.out.println("PRINTAD GEALL REPOSRIOTY");
       return allMovie;
    }


    public void insert (Movie movie) {

       new insertAsyncTask(movieDAO).execute(movie);
    }

    public void deleteMovie(String idMovie)  {

        new deleteMovieAsyncTask(movieDAO).execute(idMovie);
    }

    private static class insertAsyncTask extends AsyncTask<Movie, Void, Void> {

        private MovieDAO mAsyncTaskDao;

        insertAsyncTask(MovieDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Movie... params) {
            mAsyncTaskDao.insert(params[0]);


            return null;
        }
    }

    private static class deleteMovieAsyncTask extends AsyncTask<String, Void, Void> {
        private MovieDAO mAsyncTaskDao;

        deleteMovieAsyncTask(MovieDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final String... params) {
            mAsyncTaskDao.deleteMovie(params[0]);
            return null;
        }
    }
}

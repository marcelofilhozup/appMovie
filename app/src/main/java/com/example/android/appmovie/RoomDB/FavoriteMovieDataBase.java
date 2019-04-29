package com.example.android.appmovie.RoomDB;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.android.appmovie.model.Movie;

@Database(entities = {Movie.class}, version = 1)

public abstract class FavoriteMovieDataBase extends RoomDatabase {

    public abstract MovieDAO movieDAO();

    private static volatile FavoriteMovieDataBase INSTANCE;

    public static FavoriteMovieDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (FavoriteMovieDataBase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            FavoriteMovieDataBase.class, "Movie_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final MovieDAO mDao;

        PopulateDbAsync(FavoriteMovieDataBase db) {
            mDao =  db.movieDAO();
        }

        @Override
        protected Void doInBackground(final Void... params) {

            return null;
        }
    }
}

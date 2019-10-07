package com.example.android.appmovie.movie_detail;

import com.example.android.appmovie.bases.BaseContract;
import com.example.android.appmovie.model.ListMovie;
import com.example.android.appmovie.model.MovieDetail;

public class MovieDetailContract {

    interface View extends BaseContract.View {

        void getDetailMovie(MovieDetail movieDetail);

        void setFirstPage(ListMovie listMovie);

        void setOthersPage(ListMovie listMovie);
    }

    interface Presenter extends BaseContract.Presenter {

        void getDetailMovie(String id);

        void getListMovie(String name, final String page);
    }
}

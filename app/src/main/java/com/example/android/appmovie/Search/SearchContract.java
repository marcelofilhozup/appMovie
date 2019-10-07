package com.example.android.appmovie.Search;

import com.example.android.appmovie.bases.BaseContract;
import com.example.android.appmovie.model.ListMovie;

public class SearchContract {

    interface View extends BaseContract.View {

       void teste();
       void setFirstPage(ListMovie listMovie);
        void setOthersPage(ListMovie listMovie);

    }

    interface Presenter extends BaseContract.Presenter {

        void testePresenter();

        void getListMovie(String name, String page);




    }
}

package com.example.android.appmovie.Search;

import com.example.android.appmovie.bases.BasePresenter;
import com.example.android.appmovie.model.ListMovie;
import com.example.android.appmovie.model.MovieDetail;
import com.example.android.appmovie.repository.HomeRepository;
import com.example.android.appmovie.repository.HomeRepositoryImpl;

public class SearchPresenter extends BasePresenter implements SearchContract.Presenter {

    private HomeRepositoryImpl homeRepositoryImpl;
    private SearchContract.View mView;
    private String page;

    SearchPresenter(SearchContract.View view){
        super(view);
        this.mView =(view);
        this.homeRepositoryImpl = new HomeRepositoryImpl();
    }

    @Override
    public void init() {

    }

    @Override
    public void getListMovie(String name, final String page){


        homeRepositoryImpl.getMovieList(name, page, new HomeRepository.MovieListaCallBack() {
            @Override
            public void onSuccess(ListMovie response) {
                if(page.equals("1")){
                    mView.setFirstPage(response);
                } else {
                    mView.setOthersPage(response);
                }

            }
        });
    }



    @Override
    public void testePresenter() {

    }
}

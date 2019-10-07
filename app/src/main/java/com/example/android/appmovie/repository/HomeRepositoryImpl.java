package com.example.android.appmovie.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;


import com.example.android.appmovie.connect.RetrofitConfig;
import com.example.android.appmovie.model.ListMovie;
import com.example.android.appmovie.model.MovieDetail;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeRepositoryImpl implements HomeRepository {



    @Override
    public void getMovieList(String name, String page, final MovieListaCallBack callBack) {

        Call<ListMovie> call = new RetrofitConfig().getMovieService().getListMovie(name,page);

        call.enqueue(new Callback<ListMovie>() {
            @Override
            public void onResponse(Call<ListMovie> call, Response<ListMovie> response) {
                callBack.onSuccess(response.body());

            }

            @Override
            public void onFailure(Call<ListMovie> call, Throwable t) {
                Log.e("EMAILService", "Erro ao buscar o email:" + t.getMessage());
            }
        });
    }

    @Override
    public void getMovieDetail(String id, final MovieDetailCallBack callBack) {
        Call<MovieDetail> call = new RetrofitConfig().getMovieService().getDetailMovie(id);

        call.enqueue(new Callback<MovieDetail>() {
            @Override
            public void onResponse(Call<MovieDetail> call, Response<MovieDetail> response) {
                MovieDetail movieDetail = response.body();
                callBack.onSuccess(response.body());

            }

            @Override
            public void onFailure(Call<MovieDetail> call, Throwable t) {
                Log.e("EMAILService   ", "Erro ao buscar o email:" + t.getMessage());
                System.out.println("NAO DEU CERTOOOO");
            }
        });

    }

    @Override
    public void getMovieListDetail(String id, final MovieListaCallBack callBack) {
        Call<ListMovie> call = new RetrofitConfig().getMovieService().getListMovieDetail(id);

        call.enqueue(new Callback<ListMovie>() {
            @Override
            public void onResponse(Call<ListMovie> call, Response<ListMovie> response) {
               callBack.onSuccess(response.body());

            }

            @Override
            public void onFailure(Call<ListMovie> call, Throwable t) {
                Log.e("EMAILService", "Erro ao buscar o email:" + t.getMessage());
            }
        });
    }


    public LiveData<ListMovie> getMovieListDetail(String id) {


        Call<ListMovie> call = new RetrofitConfig().getMovieService().getListMovieDetail(id);
        final MutableLiveData<ListMovie> data = new MutableLiveData<>();

        call.enqueue(new Callback<ListMovie>() {
            @Override
            public void onResponse(Call<ListMovie> call, Response<ListMovie> response) {
                data.setValue(response.body());

            }

            @Override
            public void onFailure(Call<ListMovie> call, Throwable t) {
                Log.e("EMAILService", "Erro ao buscar o email:" + t.getMessage());
            }
        });

        return data;
    }

//    public LiveData<MovieDetail> getMovieDetail(String id){
//        Call<MovieDetail> call = new RetrofitConfig().getMovieService().getDetailMovie(id);
//        final MutableLiveData<MovieDetail> data = new MutableLiveData<>();
//        System.out.println("ENTROI GETMOVIE DETAAAAIL");
//        call.enqueue(new Callback<MovieDetail>() {
//            @Override
//            public void onResponse(Call<MovieDetail> call, Response<MovieDetail> response) {
//                MovieDetail movieDetail = response.body();
//                System.out.println("PRINTANDO NO REPOSITARIOOOOOO");
//                System.out.println(movieDetail.getTitle());
//                data.setValue(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<MovieDetail> call, Throwable t) {
//                Log.e("EMAILService   ", "Erro ao buscar o email:" + t.getMessage());
//                System.out.println("NAO DEU CERTOOOO");
//            }
//        });
//
//        return data;
//    }



}

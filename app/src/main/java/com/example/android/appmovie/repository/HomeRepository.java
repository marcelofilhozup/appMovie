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

public class HomeRepository {



    public LiveData<ListMovie> getMovieList(String name) {

        System.out.println("PRINTANDOOO GET MOIVEEE LSIT ---------");
        System.out.println(name);
        Call<ListMovie> call = new RetrofitConfig().getMovieService().getListMovie(name);
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

    public LiveData<ListMovie> getMovieListDetail(String id) {

        System.out.println("PRITANDO DO REPOSITORY DETAIL ");
        System.out.println(id);
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

    public LiveData<MovieDetail> getMovieDetail(String id){
        Call<MovieDetail> call = new RetrofitConfig().getMovieService().getDetailMovie(id);
        final MutableLiveData<MovieDetail> data = new MutableLiveData<>();
        System.out.println("ENTROI GETMOVIE DETAAAAIL");
        call.enqueue(new Callback<MovieDetail>() {
            @Override
            public void onResponse(Call<MovieDetail> call, Response<MovieDetail> response) {
                MovieDetail movieDetail = response.body();
                System.out.println("PRINTANDO NO REPOSITARIOOOOOO");
                System.out.println(movieDetail.getTitle());
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<MovieDetail> call, Throwable t) {
                Log.e("EMAILService   ", "Erro ao buscar o email:" + t.getMessage());
                System.out.println("NAO DEU CERTOOOO");
            }
        });

        return data;
    }


}

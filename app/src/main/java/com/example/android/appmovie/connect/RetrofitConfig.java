package com.example.android.appmovie.connect;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Header;

public class  RetrofitConfig {

    private final Retrofit retrofit;
    //private final Retrofit retrofitHome;
    public final static String VALUE_SERVICE =
            "f3044abd";
    public final static String NAME_SERVICE =
            "apikey";
    public final static String URL_SERVICE =
            "http://www.omdbapi.com/";

    private static String tokenHeader;

    public RetrofitConfig() {

        OkHttpClient.Builder client = new OkHttpClient.Builder();
        OkHttpClient.Builder homeService = new OkHttpClient.Builder();
        Header getFirstHeader = null;


        client.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();

                HttpUrl url = request.url().newBuilder().addQueryParameter(NAME_SERVICE, VALUE_SERVICE).build();
                request = request.newBuilder().url(url).build();
                Response response = chain.proceed(request);

                return response;
            }
        }).connectTimeout(30, TimeUnit.SECONDS) // connect timeout
                .writeTimeout(30, TimeUnit.SECONDS) // write timeout
                .readTimeout(30, TimeUnit.SECONDS);
        client.addInterceptor(logger);

//        homeService.addInterceptor(new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request request = chain.request();
//                System.out.println("TOKEM AQUI");
//                System.out.println(RetrofitConfig.tokenHeader);
//                okhttp3.Headers headers = request.headers().newBuilder().add("Authorization", "Bearer " + RetrofitConfig.tokenHeader).build();
//                request = request.newBuilder().headers(headers).build();
//                HttpUrl url = request.url().newBuilder().addQueryParameter(NAME_SERVICE, VALUE_SERVICE).build();
//                request = request.newBuilder().url(url).build();
//                RetrofitConfig.tokenHeader = chain.proceed(request).header("x-access-token");
//
//                return chain.proceed(request);
//            }
//        });
        homeService.addInterceptor(logger);

        this.retrofit = new Retrofit.Builder()
                .baseUrl(URL_SERVICE)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();

//        this.retrofitHome = new Retrofit.Builder()
//                .baseUrl(URL_SERVICE)
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(homeService.build())
//                .build();

    }

    private static HttpLoggingInterceptor logger =
            new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);



    public MovieService getMovieService() {

        return this.retrofit.create(MovieService.class);
    }

}

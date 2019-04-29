package com.example.android.appmovie.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.appmovie.Interface.OnOpenDetailMovie;
import com.example.android.appmovie.R;
import com.example.android.appmovie.Utility.PaginationScrollListener;
import com.example.android.appmovie.adapter.ListMovieAdapterDetail;
import com.example.android.appmovie.model.ListMovie;
import com.example.android.appmovie.model.MovieDetail;
import com.example.android.appmovie.viewModel.MovieDetailViewModel;

public class MovieDetailActivity extends AppCompatActivity implements OnOpenDetailMovie {

    private  String id;
    int page = 1;
    TextView titleActionBar;
    private TextView description;
    private boolean isLoading = false;
    private ImageView bannerMovie, posterMovie;
    private MovieDetailViewModel movieDetailViewModel;
    String text = "<font color=#FFFFFF><b>OT</b></font><font color=#FFFFFF>MOVIES</font>";
    private RecyclerView mRecyclerView;
    private ListMovieAdapterDetail mAdapter;
    private LinearLayoutManager linearLayoutManager;
    public static final String EXTRA_MESSAGE_OBJECT =
            "ID";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);


        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar_movie_detail);
        setSupportActionBar(myToolbar);
        titleActionBar = (TextView) findViewById(R.id.titleActionBar_movie_detail);
        titleActionBar.setText(Html.fromHtml(text));
        movieDetailViewModel = ViewModelProviders.of(this).get(MovieDetailViewModel.class);

        Intent intent = getIntent();

        id = intent.getStringExtra("ID");

        movieDetailViewModel.init(String.valueOf(id));
        movieDetailViewModel.getMovieDetail().observe(this, observerMovieDetail);


        mAdapter = new ListMovieAdapterDetail(this);
        mRecyclerView = findViewById(R.id.recyclerview_movie_detail);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        movieDetailViewModel.getListMovie().observe(this, observerMovieList);
        mAdapter.setOpenDetailMovie(this);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnScrollListener(new PaginationScrollListener(linearLayoutManager) {
            @Override
            protected void loadMoreItems() {
                isLoading = true;
                page++;
                System.out.println("CHEGOU NO FINAL NA LISTAAA ------------*!");
                movieDetailViewModel.initMovieList(String.valueOf(id));
            }

            @Override
            public int getTotalPageCount() {
                return 10;
            }

            @Override
            public boolean isLastPage() {
                return false;
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }
        });


    }

    Observer<MovieDetail> observerMovieDetail = new Observer<MovieDetail>() {
        @Override
        public void onChanged(@Nullable MovieDetail movieDetail) {
            movieDetailViewModel.initMovieList(String.valueOf(id));
            System.out.println("ENTROOOOOU OBESERVERE MOVIE DETAAAAL");
            mAdapter.setMovieDetail(movieDetail);

//            bannerMovie = (ImageView) findViewById(R.id.banner_movie_detail);
//            posterMovie = (ImageView) findViewById(R.id.poster_movie_detail);
//            description = (TextView) findViewById(R.id.description_detail);
//            description.setText(movieDetail.getOverview());
//            String url = String.format("https://ole.dev.gateway.zup.me/client-training/v1/movies/%s/image/w500?gw-app-key=593c3280aedd01364c73000d3ac06d76", movieDetail.getBannerId());
//            String urlPoster = String.format("https://ole.dev.gateway.zup.me/client-training/v1/movies/%s/image/w500?gw-app-key=593c3280aedd01364c73000d3ac06d76", movieDetail.getPosterId());
//            Picasso.with(MovieDetailActivity.this).load(url).fit().centerCrop().into(bannerMovie);
//            Picasso.with(MovieDetailActivity.this).load(urlPoster).into(posterMovie);

        }
    };

    Observer<ListMovie> observerMovieList= new Observer<ListMovie>() {
        @Override
        public void onChanged(@Nullable ListMovie movieList) {

            System.out.println("ENTROOOU NO OBERSERVER MOVIEE LIEST");
            if (page==1){
                mAdapter.setMovieList(movieList);
                mAdapter.addLoadingFooter();
            }

            else if(page>1) {
                mAdapter.removeLoadingFooter();
                mAdapter.addAll(movieList);
                mAdapter.addLoadingFooter();
            }

//

            isLoading = false;


        }
    };

    public boolean isLoading() {
        return isLoading;
    }

    public void setLoading(boolean loading) {
        isLoading = loading;
    }


    @Override
    public void openMovieDetail(String id) {

        Intent intent = new Intent(this, MovieDetailActivity.class);
        intent.putExtra(EXTRA_MESSAGE_OBJECT, id);

        startActivity(intent);
    }

    public void back_activity(View view) {this.finish();
    }

}
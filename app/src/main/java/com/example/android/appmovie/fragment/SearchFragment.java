package com.example.android.appmovie.fragment;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.Bundle;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.appmovie.Interface.OnInsertFavorite;
import com.example.android.appmovie.Interface.OnOpenDetailMovie;
import com.example.android.appmovie.activity.MovieDetailActivity;
import com.example.android.appmovie.adapter.ListMovieAdapter;
import com.example.android.appmovie.R;
import com.example.android.appmovie.model.ListMovie;
import com.example.android.appmovie.model.Movie;
import com.example.android.appmovie.viewModel.RoomViewModel;
import com.example.android.appmovie.viewModel.SearchFragmentViewModel;

import java.util.Timer;
import java.util.TimerTask;

public class SearchFragment extends Fragment implements OnOpenDetailMovie,OnInsertFavorite {


    private SearchFragmentViewModel searchFragmentViewModel;
    private TextView textView;
    private EditText editText;
    Toast mytoast;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView mRecyclerView;
    private RoomViewModel roomViewModel;
    private ImageView backButton;
    private ListMovieAdapter mAdapter;
    private Timer timer;
    public static final String EXTRA_MESSAGE_OBJECT =
            "ID";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_search, container, false);

        editText = v.findViewById(R.id.edit_search);

        backButton = v.findViewById(R.id.back_search);

        searchFragmentViewModel =  ViewModelProviders.of(this).get(SearchFragmentViewModel.class);
        roomViewModel = ViewModelProviders.of(this).get(RoomViewModel.class);

        View layouttoast = inflater.inflate(R.layout.toast_favorit_insert,(ViewGroup)v.findViewById(R.id.toast_layout));

        mytoast = new Toast(getActivity());
        mytoast.setGravity(Gravity.CENTER,0,0);
        mytoast.setView(layouttoast);
        mytoast.setDuration(Toast.LENGTH_LONG);


        editText.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //here is your code
                if (timer != null) {
                    timer.cancel();
                }


            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub


            }

            @Override
            public void afterTextChanged(Editable s) {
                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        searchFragmentViewModel.init(editText.getText().toString());
                    }
                }, 750);
            }
        });


        mAdapter = new ListMovieAdapter(v.getContext());
        mRecyclerView = v.findViewById(R.id.recyclerview_search);
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        searchFragmentViewModel.getListMovie().observe(this, observerMovieList);
        mAdapter.setOpenDetailMovie(this);
        mAdapter.setInsertFavorite(this);
        mRecyclerView.setAdapter(mAdapter);

        return v;
    }

    Observer<ListMovie> observerMovieList= new Observer<ListMovie>() {
        @Override
        public void onChanged(@Nullable ListMovie movieList) {

            if(movieList!=null)
            mAdapter.setMovieList(movieList);

        }
    };

    @Override
    public void openMovieDetail(String id) {

        Intent intent = new Intent(getActivity(), MovieDetailActivity.class);
        intent.putExtra(EXTRA_MESSAGE_OBJECT, id);

        startActivity(intent);
    }

    @Override
    public void insertFavorite(Movie movie) {

        Toast.makeText(getActivity(), "Filme salvo nos favoritos",
                Toast.LENGTH_LONG);
        mytoast.show();

        roomViewModel.insert(movie);
    }
}

package com.example.android.appmovie.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.android.appmovie.Interface.OnDeleteMovie;
import com.example.android.appmovie.R;
import com.example.android.appmovie.adapter.ListMovieHomeAdapter;
import com.example.android.appmovie.model.Movie;
import com.example.android.appmovie.viewModel.RoomViewModel;

import java.util.List;

public class HomeFragment extends Fragment implements OnDeleteMovie {


    TextView myAwesomeTextView;
    String t;
    ImageButton navigationButton;


    TextView titleActionBar;
    String text = "<font color=#FFFFFF><b>APP</b></font><font color=#FFFFFF>MOVIES</font>";

    private LinearLayoutCompat logoutButton;
    private TextView emailView;
    private TextView userView;
    private ListMovieHomeAdapter mAdapter;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView mRecyclerView;
    private RoomViewModel roomViewModel;
    private PagerAdapter adapter;
    private ViewPager viewPager;
    private ImageButton favoriteButton;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);


        roomViewModel = ViewModelProviders.of(this).get(RoomViewModel.class);

        Toolbar myToolbar = (Toolbar) v.findViewById(R.id.my_toolbar);
        titleActionBar = (TextView) v.findViewById(R.id.titleActionBar);
        titleActionBar.setText(Html.fromHtml(text));

        mAdapter = new ListMovieHomeAdapter(v.getContext());
        mRecyclerView = v.findViewById(R.id.recyclerview_home);
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

//        roomViewModel.getAllMovie().observe(this, new Observer<List<Movie>>() {
//            @Override
//            public void onChanged(@Nullable final List<Movie> movieList) {
//                // Update the cached copy of the words in the adapter.
//                if(movieList==null){
//
//                }
//                mAdapter.setMovieList(movieList);
//
//            }
//        });
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter.setDeleteMovie(this);
        mRecyclerView.setAdapter(mAdapter);


        return v;

    }


    @Override
    public void deleteMovie(String id) {
        roomViewModel.delete(id);
    }
}



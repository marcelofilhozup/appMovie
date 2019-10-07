package com.example.android.appmovie.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.android.appmovie.Interface.OnInsertFavorite;
import com.example.android.appmovie.Interface.OnOpenDetailMovie;
import com.example.android.appmovie.R;
import com.example.android.appmovie.model.ListMovie;
import com.example.android.appmovie.model.Movie;
import com.squareup.picasso.Picasso;

public class ListMovieAdapter extends  RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ListMovie movieList;
    private OnOpenDetailMovie openDetailMovie;
    private OnInsertFavorite insertFavorite;
    private LayoutInflater inflater;
    private Context context;
    private boolean isLoadingAdded = false;
    String url;

    private final int ITEM = 0;
    private final int LOADING = 1;

    public ListMovieAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        this.context = context;

    }

    public void setOpenDetailMovie(OnOpenDetailMovie openDetailMovie){

        this.openDetailMovie = openDetailMovie;
    }

    public void setInsertFavorite(OnInsertFavorite onInsertFavorite){
        this.insertFavorite = onInsertFavorite;
    }

    public void setMovieList(ListMovie listMovie){

        this.movieList = listMovie;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView;
        RecyclerView.ViewHolder viewHolder = null;

        switch (i) {
            case ITEM:
                View viewItem = inflater.inflate(R.layout.movie_item_list, viewGroup, false);
                viewHolder = new MovieViewHolder(viewItem,this);
                break;
            case LOADING:
                View viewLoading = inflater.inflate(R.layout.item_loading, viewGroup, false);
                viewHolder = new LoadingViewHolder(viewLoading,this);
                break;

        }
        return viewHolder;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int position) {


        switch (getItemViewType(position)) {


            case ITEM:

                final MovieViewHolder movieViewHolder = (MovieViewHolder) viewHolder;

                url = movieList.getMovie().get(position).getPoster();

                movieViewHolder.movieTitle.setText(movieList.getMovie().get(position).getTitle());
                movieViewHolder.movieOverView.setText(movieList.getMovie().get(position).getOverview());
                movieViewHolder.movieYear.setText(movieList.getMovie().get(position).getYear());
                movieViewHolder.movieVoteAverage.setText(movieList.getMovie().get(position).getVote_average());
                Picasso.with(context).load(url).into(movieViewHolder.imageMovie);
//
//                String genres = String.join(", ", movieList.getMovie().get(position).getGenreNames());
//                movieViewHolder.movieGenres.setText(genres);

                movieViewHolder.view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openDetailMovie.openMovieDetail(movieList.getMovie().get(position).getImdbID());
                    }
                });

                movieViewHolder.imageFavorite.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {

                        insertFavorite.insertFavorite(movieList.getMovie().get(position));

                    }
                });


                break;

            case LOADING:
                LoadingViewHolder loadingVH = (LoadingViewHolder) viewHolder;
                loadingVH.mProgressBar.setVisibility(View.VISIBLE);
                break;
        }

    }

    @Override
    public int getItemCount() {

        if(movieList==null){
            return 0;
        }

        return movieList.getMovie().size();
    }


    class MovieViewHolder extends RecyclerView.ViewHolder {

        final ListMovieAdapter mAdapter;
        //       private final TextView movieTitle,movieYear,movieOverView,moviePrice,movieRunTime,movieGenres;
        private final ImageView imageMovie,imageFavorite;
        private final TextView movieTitle, movieYear,  movieVoteAverage, movieOverView;
        private final View view;


        public MovieViewHolder(@NonNull View itemView, ListMovieAdapter adapter) {
            super(itemView);


            this.mAdapter = adapter;
            view = itemView;
            movieTitle = itemView.findViewById(R.id.movie_title);
            movieYear = itemView.findViewById(R.id.year_movie);
            movieOverView = itemView.findViewById(R.id.description_movie);
            imageMovie = itemView.findViewById(R.id.imagemMovie);
            movieVoteAverage = itemView.findViewById(R.id.note_movie);
            imageFavorite = itemView.findViewById(R.id.favorite_movie);

        }
    }

    @Override
    public int getItemViewType(int position) {

        return (position == movieList.getMovie().size() - 1 && isLoadingAdded) ? LOADING : ITEM;

    }

    protected class LoadingViewHolder extends RecyclerView.ViewHolder {
        private ProgressBar mProgressBar;


        public LoadingViewHolder(View itemView,ListMovieAdapter adapter) {
            super(itemView);

            mProgressBar = itemView.findViewById(R.id.progress_bar_loading);

        }

    }

    public void addLoadingFooter() {
        isLoadingAdded = true;
        add(new Movie());
    }

    public void removeLoadingFooter() {
        isLoadingAdded = false;

        int position = movieList.getMovie().size() - 1;
        Movie movie = getItem(position);

        if (movie != null) {
            movieList.getMovie().remove(position);
            notifyItemRemoved(position);
        }
    }

    public Movie getItem(int position) {
        return movieList.getMovie().get(position);
    }


    public void add(Movie movie) {
        movieList.getMovie().add(movie);
        notifyItemInserted(movieList.getMovie().size() - 1);
    }

    public void addAll(ListMovie listMovie) {

        for (Movie movie : listMovie.getMovie()) {
            add(movie);
        }
    }
}

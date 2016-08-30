package com.nispok.thecritic.movies;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nispok.thecritic.R;
import com.nispok.tmdb.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

class MoviesRecyclerViewAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private List<Movie> movies;
    private MovieListener listener;

    public MoviesRecyclerViewAdapter(@NonNull MovieListener listener) {
        this.listener = listener;
        movies = new ArrayList<>();
    }

    public void add(List<Movie> movies) {
        this.movies.addAll(movies);
        notifyItemRangeInserted(this.movies.size() - movies.size(), movies.size());
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        final Movie movie = movies.get(position);
        holder.setMovie(movie);
        holder.getContainer().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onMovieSelected(movie);
            }
        });

        Picasso.with(holder.getContainer().getContext())
                .load(movie.getPosterUrl())
                .error(R.mipmap.ic_launcher)
                .into(holder.getImage());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public interface MovieListener {
        void onMovieSelected(Movie movie);
    }
}

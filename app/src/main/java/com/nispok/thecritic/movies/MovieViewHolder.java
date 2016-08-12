package com.nispok.thecritic.movies;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.nispok.thecritic.R;
import com.nispok.tmdb.Movie;

class MovieViewHolder extends RecyclerView.ViewHolder {

    private final View container;
    private final ImageView image;
    private Movie movie;

    public MovieViewHolder(View itemView) {
        super(itemView);
        container = itemView;
        image = (ImageView) itemView.findViewById(R.id.movie_image);
    }

    public View getContainer() {
        return container;
    }

    public ImageView getImage() {
        return image;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}

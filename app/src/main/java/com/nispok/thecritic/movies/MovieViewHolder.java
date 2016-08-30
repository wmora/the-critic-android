package com.nispok.thecritic.movies;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nispok.thecritic.R;
import com.nispok.tmdb.Movie;

class MovieViewHolder extends RecyclerView.ViewHolder {

    private final View container;
    private final ImageView image;
    private final TextView title;
    private final TextView subtitle;
    private Movie movie;

    public MovieViewHolder(View itemView) {
        super(itemView);
        container = itemView;
        image = (ImageView) itemView.findViewById(R.id.movie_image);
        title = (TextView) itemView.findViewById(R.id.movie_title);
        subtitle = (TextView) itemView.findViewById(R.id.movie_subtitle);
    }

    public View getContainer() {
        return container;
    }

    public ImageView getImage() {
        return image;
    }

    public TextView getTitle() {
        return title;
    }

    public TextView getSubtitle() {
        return subtitle;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}

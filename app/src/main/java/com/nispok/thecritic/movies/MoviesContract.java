package com.nispok.thecritic.movies;

import com.nispok.thecritic.BasePresenter;
import com.nispok.thecritic.BaseView;
import com.nispok.tmdb.Movie;

import java.util.List;

interface MoviesContract {

    interface View extends BaseView<Presenter> {
        void showLoading();

        void hideLoading();

        void showMovies(List<Movie> movies);
    }

    interface Presenter extends BasePresenter {
    }

}

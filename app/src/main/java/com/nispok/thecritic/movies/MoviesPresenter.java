package com.nispok.thecritic.movies;

import android.util.Log;

import com.nispok.thecritic.BuildConfig;
import com.nispok.tmdb.Movie;
import com.nispok.tmdb.MovieResults;
import com.nispok.tmdb.Tmdb;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

class MoviesPresenter implements MoviesContract.Presenter {

    private static final String TAG = MoviesPresenter.class.getName();

    private Tmdb tmdb;
    private MoviesContract.View view;

    @Inject
    MoviesPresenter(Tmdb tmdb, MoviesContract.View view) {
        this.tmdb = tmdb;
        this.view = view;
    }

    @Inject
    void setUpListeners() {
        view.setPresenter(this);
    }

    @Override
    public void start() {
        view.showLoading();
        loadMovies();
    }

    private void loadMovies() {
        Observable<MovieResults> movies = tmdb.getService()
                .nowPlayingMovies(BuildConfig.TMDB_API_KEY, 1, "en")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        movies.subscribe(new Observer<MovieResults>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MovieResults movieResults) {
                view.showMovies(movieResults.getResults());
                view.hideLoading();
            }
        });
    }

    @Override
    public void movieSelected(Movie movie) {
        Log.d(TAG, "Movie selected: " + movie.getTitle());
    }
}

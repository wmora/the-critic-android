package com.nispok.thecritic.movies;

import com.nispok.thecritic.BuildConfig;
import com.nispok.tmdb.MovieResults;
import com.nispok.tmdb.Tmdb;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MoviesPresenter implements MoviesContract.Presenter {

    private Tmdb tmdb = new Tmdb();
    private MoviesContract.View view;

    @Inject
    MoviesPresenter(MoviesContract.View view) {
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
}

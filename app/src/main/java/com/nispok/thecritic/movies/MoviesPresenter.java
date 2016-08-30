package com.nispok.thecritic.movies;

import android.util.Log;

import com.nispok.thecritic.BuildConfig;
import com.nispok.tmdb.Configuration;
import com.nispok.tmdb.Movie;
import com.nispok.tmdb.MovieResults;
import com.nispok.tmdb.Tmdb;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.SingleSubscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

class MoviesPresenter implements MoviesContract.Presenter {

    private static final String TAG = MoviesPresenter.class.getName();

    private Tmdb tmdb;
    private MoviesContract.View view;
    private Configuration configuration;

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
        loadConfiguration();
    }

    private void loadConfiguration() {
        tmdb.getService().configuration(BuildConfig.TMDB_API_KEY)
                .subscribeOn(Schedulers.newThread())
                .subscribe(new SingleSubscriber<Configuration>() {
                    @Override
                    public void onSuccess(Configuration value) {
                        configuration = value;
                        loadMovies();
                    }

                    @Override
                    public void onError(Throwable error) {
                        view.showError(error.getMessage());
                    }
                });

    }

    private void loadMovies() {
        Observable<MovieResults> movies = tmdb.getService()
                .nowPlayingMovies(BuildConfig.TMDB_API_KEY, 1, "en")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<MovieResults, MovieResults>() {
                    @Override
                    public MovieResults call(MovieResults movieResults) {
                        String posterBaseUrl = configuration.getImages().getBaseUrl()
                                + configuration.getImages().getPosterSizes().get(
                                configuration.getImages().getPosterSizes().size() - 1);
                        for (Movie movie : movieResults.getResults()) {
                            movie.setPosterUrl(posterBaseUrl + movie.getPosterPath());
                            movie.setBackdropUrl(posterBaseUrl + movie.getBackdropPath());
                        }
                        return movieResults;
                    }
                });
        movies.subscribe(new Observer<MovieResults>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                view.showError(e.getMessage());
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

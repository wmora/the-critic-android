package com.nispok.thecritic.movies;

import dagger.Module;
import dagger.Provides;

@Module
public class MoviesPresenterModule {

    private final MoviesContract.View view;

    public MoviesPresenterModule(MoviesContract.View view) {
        this.view = view;
    }

    @Provides
    MoviesContract.View providesMoviesContractView() {
        return view;
    }
}

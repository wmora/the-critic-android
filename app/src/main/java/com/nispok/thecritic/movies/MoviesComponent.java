package com.nispok.thecritic.movies;

import dagger.Component;

@Component(modules = MoviesPresenterModule.class)
interface MoviesComponent {

    void inject(MoviesActivity activity);

}

package com.nispok.thecritic.movies;

import com.nispok.thecritic.data.TmdbModule;

import dagger.Component;

@Component(modules = {MoviesPresenterModule.class, TmdbModule.class})
interface MoviesComponent {

    void inject(MoviesActivity activity);

}

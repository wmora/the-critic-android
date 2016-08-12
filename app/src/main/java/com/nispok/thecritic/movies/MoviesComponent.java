package com.nispok.thecritic.movies;

import com.nispok.thecritic.data.TmdbComponent;
import com.nispok.thecritic.di.ActivityScoped;

import dagger.Component;

@ActivityScoped
@Component(dependencies = TmdbComponent.class, modules = MoviesPresenterModule.class)
interface MoviesComponent {

    void inject(MoviesActivity activity);

}

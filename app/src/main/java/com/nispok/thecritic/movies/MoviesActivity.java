package com.nispok.thecritic.movies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nispok.thecritic.R;
import com.nispok.thecritic.data.TmdbModule;

import javax.inject.Inject;

public class MoviesActivity extends AppCompatActivity {

    @Inject
    MoviesPresenter moviesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        MoviesFragment moviesFragment = MoviesFragment.newInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, moviesFragment)
                .commit();

        DaggerMoviesComponent.builder()
                .tmdbModule(new TmdbModule())
                .moviesPresenterModule(new MoviesPresenterModule(moviesFragment)).build()
                .inject(this);
    }
}

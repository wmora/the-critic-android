package com.nispok.thecritic.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nispok.thecritic.R;
import com.nispok.thecritic.fragments.MoviesFragment;

public class MoviesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        MoviesFragment moviesFragment = MoviesFragment.newInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, moviesFragment)
                .commit();
    }
}

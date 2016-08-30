package com.nispok.thecritic.movies;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.nispok.thecritic.R;
import com.nispok.tmdb.Movie;

import java.util.List;

public class MoviesFragment extends Fragment implements MoviesContract.View,
        MoviesRecyclerViewAdapter.MovieListener {

    private static final String TAG = MoviesFragment.class.getName();

    private FrameLayout loadingView;
    private MoviesRecyclerViewAdapter adapter;

    private MoviesContract.Presenter presenter;

    public static MoviesFragment newInstance() {
        return new MoviesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        adapter = new MoviesRecyclerViewAdapter(this);
        recyclerView.setAdapter(adapter);
        loadingView = (FrameLayout) view.findViewById(R.id.loading_view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.start();
    }

    @Override
    public void showLoading() {
        loadingView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        loadingView.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {
        Log.e(TAG, message);
    }

    @Override
    public void showMovies(List<Movie> movies) {
        adapter.add(movies);
    }

    @Override
    public void setPresenter(@NonNull MoviesContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onMovieSelected(Movie movie) {
        presenter.movieSelected(movie);
    }
}

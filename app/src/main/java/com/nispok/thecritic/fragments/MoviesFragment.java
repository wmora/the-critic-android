package com.nispok.thecritic.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.nispok.thecritic.BuildConfig;
import com.nispok.thecritic.R;
import com.nispok.thecritic.adapters.MoviesRecyclerViewAdapter;
import com.nispok.tmdb.MovieResults;
import com.nispok.tmdb.Tmdb;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MoviesFragment extends Fragment {

    private Tmdb tmdb = new Tmdb();

    private FrameLayout loadingView;
    private MoviesRecyclerViewAdapter adapter;

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
        adapter = new MoviesRecyclerViewAdapter();
        recyclerView.setAdapter(adapter);
        loadingView = (FrameLayout) view.findViewById(R.id.loading_view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        showLoading();
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
                adapter.add(movieResults.getResults());
                hideLoading();
            }
        });
    }

    private void showLoading() {
        loadingView.setVisibility(View.VISIBLE);
    }

    private void hideLoading() {
        loadingView.setVisibility(View.GONE);
    }

}

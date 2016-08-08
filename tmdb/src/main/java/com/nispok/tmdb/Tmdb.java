package com.nispok.tmdb;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class Tmdb {

    private static final String BASE_URL = "https://api.themoviedb.org/3";

    private TmdbService service;

    public Tmdb() {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        service = retrofit.create(TmdbService.class);
    }

    public TmdbService getService() {
        return service;
    }

}

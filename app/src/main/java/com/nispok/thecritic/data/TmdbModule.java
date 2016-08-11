package com.nispok.thecritic.data;

import com.nispok.tmdb.Tmdb;

import dagger.Module;
import dagger.Provides;

@Module
public class TmdbModule {

    @Provides
    Tmdb providesTmdb() {
        return new Tmdb();
    }
}

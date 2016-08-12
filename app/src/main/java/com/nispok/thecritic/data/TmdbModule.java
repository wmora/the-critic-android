package com.nispok.thecritic.data;

import com.nispok.tmdb.Tmdb;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TmdbModule {

    @Provides @Singleton
    Tmdb providesTmdb() {
        return new Tmdb();
    }
}

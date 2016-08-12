package com.nispok.thecritic.data;

import com.nispok.tmdb.Tmdb;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = TmdbModule.class)
public interface TmdbComponent {

    Tmdb getTmdb();

}

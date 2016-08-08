package com.nispok.tmdb;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface TmdbService {

    /**
     * Get the list of movies playing that have been, or are being released this week.
     *
     * @param page     Minimum 1, maximum 1000.
     * @param language ISO 639-1 code.
     * @return the list of movies playing that have been, or are being released this week.
     */
    @GET("movie/now_playing")
    Observable<MovieResults> nowPlayingMovies(@Query("page") int page, @Query("language") String language);

}

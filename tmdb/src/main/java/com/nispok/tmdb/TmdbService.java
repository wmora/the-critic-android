package com.nispok.tmdb;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import rx.Single;

public interface TmdbService {

    /**
     * Get the list of movies playing that have been, or are being released this week.
     *
     * @param apiKey   API key.
     * @param page     Minimum 1, maximum 1000.
     * @param language ISO 639-1 code.
     * @return the list of movies playing that have been, or are being released this week.
     */
    @GET("movie/now_playing")
    Observable<MovieResults> nowPlayingMovies(@Query("api_key") String apiKey,
                                              @Query("page") int page,
                                              @Query("language") String language);

    /**
     * Get the system wide configuration information. Some elements of the API require some
     * knowledge of this configuration data. The purpose of this is to try and keep the actual API
     * responses as light as possible. It is recommended you cache this data within your
     * application and check for updates every few days.
     * <p/>
     * This method currently holds the data relevant to building image URLs as well as the change
     * key map.
     * <p/>
     * To build an image URL, you will need 3 pieces of data. The base_url, size and file_path.
     * Simply combine them all and you will have a fully qualified URL. Here’s an example URL:
     * <p/>
     * http://image.tmdb.org/t/p/w500/8uO0gUM8aNqYLs1OsTBQiXu0fEv.jpg
     *
     * @param apiKey API key.
     * @return system wide configuration information.
     */
    @GET("configuration")
    Single<Configuration> configuration(@Query("api_key") String apiKey);
}

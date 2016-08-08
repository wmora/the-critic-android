package com.nispok.tmdb;

import java.util.Date;

public class Movie {

    private String id;
    private String originalLanguage;
    private String originalTitle;
    private String overview;
    private Date releaseDate;
    private String posterPath;
    private String title;

    public String getId() {
        return id;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getTitle() {
        return title;
    }

}

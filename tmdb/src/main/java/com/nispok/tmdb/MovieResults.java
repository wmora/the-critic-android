package com.nispok.tmdb;

import java.util.List;

public class MovieResults {

    private int page;
    private long totalPages;
    private long totalResults;
    private List<Movie> results;

    public long getPage() {
        return page;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public long getTotalResults() {
        return totalResults;
    }

    public List<Movie> getResults() {
        return results;
    }

}

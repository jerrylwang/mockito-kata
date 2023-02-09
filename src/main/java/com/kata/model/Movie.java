package com.kata.model;

import java.util.List;

public class Movie {
    private String title;
    private Integer year;
    private List<String> genres;
    private List<String> cast;

    public Movie(String title,
                 Integer year,
                 List<String> genres,
                 List<String> cast) {
        this.title = title;
        this.year = year;
        this.genres = genres;
        this.cast = cast;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public List<String> getGenres() {
        return genres;
    }

    public List<String> getCast() {
        return cast;
    }
}

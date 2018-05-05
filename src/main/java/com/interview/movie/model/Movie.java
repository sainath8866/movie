package com.interview.movie.model;

import java.util.Date;
import java.util.List;

public class Movie {
    private String name;
    private List<String> language;
    private String rating;
    private List<String> directors;
    private Date releaseDate;
    private List<Cast> cast;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getLanguage() {
        return language;
    }

    public void setLanguage(List<String> language) {
        this.language = language;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public void setDirectors(List<String> directors) {
        this.directors = directors;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Cast> getCast() {
        return cast;
    }

    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }

}
package com.interview.movie.service;

import com.interview.movie.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();

    Movie getMovieById(String movieName);

    Movie updateMovie(String movieName, Movie movie);

    Movie addMovie(Movie movie);

    void deleteMovie(String movieName);
}


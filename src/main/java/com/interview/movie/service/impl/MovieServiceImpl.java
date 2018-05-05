package com.interview.movie.service.impl;

import com.interview.movie.model.GlobalModel;
import com.interview.movie.model.Movie;
import com.interview.movie.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieServiceImpl.class);

    @Override
    public List<Movie> getAllMovies() {
        return new ArrayList<>(GlobalModel.movies.values());
    }

    @Override
    public Movie getMovieById(String movieName) {
        return GlobalModel.movies.get(movieName);
    }

    @Override
    public Movie updateMovie(String movieName, Movie movie) {
        Movie existingMovie = GlobalModel.movies.get(movieName);
        if (existingMovie == null) {
            throw new RuntimeException("Movie with name: " + movieName + " doesn't exist.");
        } else {
            return GlobalModel.movies.replace(movieName, movie);
        }
    }

    @Override
    public Movie addMovie(Movie movie) {
        try {
            GlobalModel.movies.put(movie.getName(), movie);
        } catch (UnsupportedOperationException | ClassCastException | NullPointerException | IllegalArgumentException ex) {
            LOGGER.info(ex.getMessage());
            throw new RuntimeException("Failed to add movie.");
        }
        return movie;
    }

    @Override
    public void deleteMovie(String movieName) {
        Movie movie = GlobalModel.movies.get(movieName);
        if (movie != null) {
            GlobalModel.movies.remove(movieName);
        }
    }

}

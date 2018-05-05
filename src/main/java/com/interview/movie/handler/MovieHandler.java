package com.interview.movie.handler;

import com.interview.movie.model.Movie;
import com.interview.movie.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieHandler {

    private final MovieService movieService;

    public MovieHandler(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping(value = "/{movieName}")
    public Movie getMovieByName(@PathVariable String movieName) {
        return movieService.getMovieById(movieName);
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @PutMapping(value = "/{movieName}")
    public Movie updateMovie(@RequestBody Movie movie, @PathVariable String movieName) {
        if (!movieName.equals(movie.getName())) {
            throw new RuntimeException("url param and movieName should be the same.");
        }
        return movieService.updateMovie(movieName, movie);
    }

    @DeleteMapping(value = "/{movieName}")
    public void addMovie(@PathVariable String movieName) {
        movieService.deleteMovie(movieName);
    }
}

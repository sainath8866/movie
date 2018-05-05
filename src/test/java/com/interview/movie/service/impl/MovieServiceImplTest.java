package com.interview.movie.service.impl;

import com.interview.movie.model.Cast;
import com.interview.movie.model.GlobalModel;
import com.interview.movie.model.Movie;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


@RunWith(SpringRunner.class)
public class MovieServiceImplTest {

    @InjectMocks
    private MovieServiceImpl movieService;

    @Before
    public void setup() throws ParseException {
        Cast cast = new Cast();
        cast.setName("Keanu Reaves");
        cast.setRole("Neo");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse("1999-03-31");

        Movie movie = new Movie();
        movie.setName("The Matrix");
        movie.setLanguage(Lists.newArrayList("English", "Spanish", "Telugu", "Hindi"));
        movie.setCast(Collections.singletonList(cast));
        movie.setDirectors(Lists.newArrayList("Lana Wachowski", "Lilly Waochowski"));
        movie.setReleaseDate(date);
        movie.setRating("8.7");

        GlobalModel.movies.clear();
        GlobalModel.movies.put(movie.getName(), movie);
    }


    @Test
    public void getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();

        assertEquals(1, movies.size());
        assertEquals("The Matrix", movies.get(0).getName());
        assertEquals("Keanu Reaves", movies.get(0).getCast().get(0).getName());
    }

    @Test
    public void getMovieById() {
        Movie movie = movieService.getMovieById("The Matrix");

        assertEquals("The Matrix", movie.getName());
        assertEquals("Keanu Reaves", movie.getCast().get(0).getName());
    }

    @Test
    public void updateMovie() {
        Movie movie = GlobalModel.movies.get("The Matrix");
        movie.setRating("9.1");
        Movie updatedMovie = movieService.updateMovie("The Matrix", movie);

        assertEquals("9.1", updatedMovie.getRating());
    }

    @Test(expected = RuntimeException.class)
    public void updateMovie_throws_RunTimeException() {
        movieService.updateMovie("Invalid Movie Name", new Movie());
    }

    @Test
    public void addMovie() {
        Movie movie = new Movie();
        movie.setName("The Matrix - 2");
        movie.setRating("9.5");

        Movie newMovie = movieService.addMovie(movie);

        assertEquals("The Matrix - 2", newMovie.getName());
        assertEquals("9.5", newMovie.getRating());
    }

    @Test(expected = RuntimeException.class)
    public void addMovie_throws_RunTimeException() {
        movieService.addMovie(null);
    }

    @Test
    public void deleteMovie() {
        movieService.deleteMovie("The Matrix");
        assertNull(GlobalModel.movies.get("The Matrix"));
    }
}
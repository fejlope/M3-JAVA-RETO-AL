package app.demo.usecase.movies;

import app.demo.domain.movies.Movie;
import app.demo.domain.movies.gateways.MovieRepository;
import app.demo.domain.technicalogs.gateways.LoggerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

public class MovieUseCaseTest {

    MoviesUseCase useCase;

    Movie movie = Movie.builder().title("Matrix").category(Movie.Categories.ACTION).build();

    @Mock
    MovieRepository repository;

    @Mock
    LoggerRepository logger;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        useCase = new MoviesUseCase(repository, logger);
    }

    @Test
    public void getMoviesTest() {
        when(repository.findAll()).thenReturn(new ArrayList<>());
        Assert.assertNotNull(useCase.getMovies());
    }

    @Test
    public void getMoviesExceptionTest() {
        when(repository.findAll()).thenThrow(new NullPointerException());
        Assert.assertNotNull(useCase.getMovies());
    }

    @Test
    public void addMovieTest()
    {
        when(repository.save(movie)).thenReturn(movie);
        useCase.addMovie(movie.getTitle(), movie.getCategory().name());
    }

    @Test
    public void addMovieExceptionTest()
    {
        when(repository.save(movie)).thenThrow(new NullPointerException());
        Assert.assertNull(useCase.addMovie(movie.getTitle(), movie.getCategory().name()));
    }

    @Test
    public void getMoviesByCategoryTest() {
        when(repository.findMoviesByCategory(movie.getCategory().name())).thenReturn(new ArrayList<>());
        Assert.assertNotNull(useCase.getMoviesByCategory(movie.getCategory().name()));
    }

    @Test
    public void getMoviesByCategoryExceptionTest() {
        when(repository.findMoviesByCategory(movie.getCategory().name())).thenThrow(new NullPointerException());
        Assert.assertNotNull(useCase.getMoviesByCategory(movie.getCategory().name()));
    }
}

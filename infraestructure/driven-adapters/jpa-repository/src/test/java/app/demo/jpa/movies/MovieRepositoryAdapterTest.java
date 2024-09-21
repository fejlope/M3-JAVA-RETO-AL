package app.demo.jpa.movies;

import app.demo.domain.movies.Movie;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.reactivecommons.utils.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class MovieRepositoryAdapterTest {

    MovieRepositoryAdapter adapter;

    @Mock
    MovieDataRepository repository;

    @Mock
    ObjectMapper mapper;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        when(mapper.map(any(), any())).thenReturn(new MovieData());
        when(mapper.mapBuilder(any(), any())).thenReturn(Movie.builder());
        adapter = new MovieRepositoryAdapter(repository, mapper);
    }

    @Test
    public void saveTest() {
        when(repository.save(any())).thenReturn(new MovieData());
        assertNotNull(adapter.save(Movie.builder().build()));
    }

    @Test
    public void findByCategotyTest() {
        when(repository.findMoviesByCategory(Categories.ACTION.name())).thenReturn(new ArrayList<MovieData>());
        assertNotNull(adapter.findMoviesByCategory(Categories.ACTION.name()));
    }

    @Test
    public void saveAllTest() {
        List<Movie> list = new ArrayList<>();
        when(repository.saveAll(new ArrayList<MovieData>())).thenReturn(new ArrayList<MovieData>());
        adapter.saveAll(list);
        assertEquals("Adding all movies to db", 0, list.size());
    }
}

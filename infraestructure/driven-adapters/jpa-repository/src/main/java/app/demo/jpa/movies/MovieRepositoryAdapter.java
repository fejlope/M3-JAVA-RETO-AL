package app.demo.jpa.movies;

import app.demo.domain.movies.Movie;
import app.demo.domain.movies.gateways.MovieRepository;
import app.demo.jpa.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepositoryAdapter extends AdapterOperations<Movie, MovieData, String, MovieDataRepository>
        implements MovieRepository {

    public MovieRepositoryAdapter(MovieDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Movie.MovieBuilder.class).build());
    }

    @Override
    public void saveAll(List<Movie> movies) {
        super.saveAllEntities(movies);
    }

    @Override
    public List<Movie> findMoviesByCategory(String category) {
        return super.toList(repository.findMoviesByCategory(category));
    }
}

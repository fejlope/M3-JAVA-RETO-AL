package app.demo.usecase.movies;

import app.demo.domain.movies.Movie;
import app.demo.domain.movies.gateways.MovieRepository;
import app.demo.domain.technicalogs.gateways.LoggerRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class MoviesUseCase {

    private final MovieRepository repository;
    private final LoggerRepository logger;

    public List<Movie> getMovies() {
        List<Movie> list = new ArrayList<>();
        try {
            list = repository.findAll();
        } catch (Exception ex) {
            logger.error("Obteniendo Peliculas", ex);
        } finally {
            return list;
        }
    }

    public Movie addMovie(String title, String categorie) {
        try {
            Movie.Categories movieCategory = Movie.Categories.valueOf(categorie);
            Movie movie = Movie.builder().title(title).category(movieCategory).build();

            return repository.save(movie);
        } catch (Exception ex) {
            logger.error("Creando movie", ex);
            return null;
        }
    }

    public List<Movie> getMoviesByCategory(String category) {
        List<Movie> list = new ArrayList<>();
        try {
            list = repository.findMoviesByCategory(category);
        } catch (Exception ex) {
            logger.error("getMoviesByCategory" , ex);
        } finally {
            return list;
        }
    }
}

package app.demo.api.rest.movie;

import app.demo.domain.movies.Movie;
import app.demo.usecase.movies.MoviesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/movies", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class MoviesService {

    private final MoviesUseCase useCase;

    @GetMapping
    public ResponseEntity getMovies() {
        List<Movie> responseList = useCase.getMovies();
        return new ResponseEntity<List<Movie>>(responseList,HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path = "/add")
    public ResponseEntity addMovie(@RequestBody Movie data) {
        useCase.addMovie(data.getTitle(), data.getCategory().name());
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/bycategory", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getMovieByCategory(@RequestParam String category) {
        List<Movie> responseList = useCase.getMoviesByCategory(category);
        return new ResponseEntity<List<Movie>>(responseList, HttpStatus.OK);
    }

}

package app.demo.config.usecase;

import app.demo.domain.movies.gateways.MovieRepository;
import app.demo.domain.technicalogs.gateways.LoggerRepository;
import app.demo.usecase.movies.MoviesUseCase;
import org.reactivecommons.utils.ObjectMapperImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public MoviesUseCase createMoviesUseCase(MovieRepository repository, LoggerRepository logger) {
        return new MoviesUseCase(repository, logger);
    }

    @Bean
    public ObjectMapperImp createObjectMapper() {
        return new ObjectMapperImp();
    }

}


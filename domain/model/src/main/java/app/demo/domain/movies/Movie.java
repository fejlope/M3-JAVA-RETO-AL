package app.demo.domain.movies;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
public class Movie {

    public enum Categories {
        ACTION,
        ADVENTURE,
        COMEDY,
        DRAMA
    }

    private final String id;

    private final String title;

    private final Categories category;


}

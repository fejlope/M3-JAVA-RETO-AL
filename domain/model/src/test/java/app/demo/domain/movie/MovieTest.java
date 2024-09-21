package app.demo.domain.movie;

import app.demo.domain.movies.Movie;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MovieTest {

    Movie movie;

    @Before
    public void init() {
        movie = Movie.builder().id("1").title("Matrix").category(Movie.Categories.ACTION).build();
    }

    @Test
    public void categoryTest() {
        Assert.assertEquals(Movie.Categories.ACTION, movie.getCategory());
    }

    @Test
    public void movieIdTest() {
        Assert.assertEquals("1", movie.getId());
    }

    @Test
    public void movieTitleTest() {
        Assert.assertEquals("Matrix", movie.getTitle());
    }

}

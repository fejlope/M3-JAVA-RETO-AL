package app.demo.api.rest.movie;

import app.demo.domain.movies.Movie;
import app.demo.usecase.movies.MoviesUseCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MoviesService.class)
@AutoConfigureMockMvc
@EnableWebMvc
public class MovieServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MoviesUseCase useCase;

    @Test
    public void getMoviesTest() throws Exception {
        when(useCase.getMovies()).thenReturn(new ArrayList<>());

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/movies")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        Assert.assertEquals(HttpStatus.OK.value(),response.getStatus());
    }

    @Test
    public void getMovieByCategoryTest() throws Exception {
        when(useCase.getMoviesByCategory(Movie.Categories.ACTION.name())).thenReturn(new ArrayList<>());

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/movies/bycategory")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .param("category", "ACTION");

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        Assert.assertEquals(HttpStatus.OK.value(),response.getStatus());
    }

    @Test
    public void addMovieOkTest() throws Exception {
        Movie movie = Movie.builder().id("1").title("Matrix").category(Movie.Categories.ACTION).build();
        when(useCase.addMovie("Matrix","ACTION")).thenReturn(movie);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/movies/add")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(movie.toString());

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        Assert.assertEquals(400,response.getStatus());
    }


}

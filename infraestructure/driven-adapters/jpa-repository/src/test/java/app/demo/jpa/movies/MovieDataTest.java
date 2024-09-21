package app.demo.jpa.movies;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MovieDataTest {

    private static MovieData movieData;

    @BeforeClass
    public static void setUpTest() {
        movieData = new MovieData();
    }

    @Test
    public void movieDataIdGetterTest() throws NoSuchFieldException, IllegalAccessException {
        Long id = 1L;
        movieData.setId(id);
        Assert.assertEquals(id, movieData.getId());
    }

    @Test
    public void movieDataNameGetterTest() throws NoSuchFieldException, IllegalAccessException {
        String title = "Duro de Matar";
        movieData.setTitle(title);
        Assert.assertEquals(title, movieData.getTitle());
    }

    @Test
    public void movieDataCategoryGetterTest() throws NoSuchFieldException, IllegalAccessException {
        movieData.setCategory(Categories.ACTION);
        Assert.assertEquals(Categories.ACTION, movieData.getCategory());
    }

    @Test
    public void movieDataCategoryEnumActionTest () {
        Assert.assertEquals("ACTION", Categories.ACTION.name());
    }

}

package app.demo.technical.logs;

import org.junit.Assert;
import org.junit.Test;

public class LoggerModelTest {

    LoggerModel model;

    @Test
    public void loggerModelFirstConstructorTest() {
        model = new LoggerModel("message", "application", "service", "name");
        Assert.assertNotNull(model);
    }

    @Test
    public void loggerModelExceptionConstructorTest() {
        model = new LoggerModel("application", "service", "name", new Exception("Error"));
        Assert.assertNotNull(model);
    }
}

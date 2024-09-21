package app.demo.domain.secrets;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SecretsTest {

    Secret secret;

    @Before
    public void init() {
        secret = Secret.builder()
                .dbName("dbName")
                .host("localhost")
                .password("abcd")
                .port("1400")
                .user("sa")
                .build();
    }

    @Test
    public void secretDbNameTest() {
        Assert.assertEquals("dbName", secret.getDbName());
    }

    @Test
    public void secretHostTest() {
        Assert.assertEquals("localhost", secret.getHost());
    }

    @Test
    public void secretPasswordTest() {
        Assert.assertEquals("abcd", secret.getPassword());
    }

    @Test
    public void secretPortTest() {
        Assert.assertEquals("1400", secret.getPort());
    }

    @Test
    public void secretUserTest() {
        Assert.assertEquals("sa", secret.getUser());
    }
}

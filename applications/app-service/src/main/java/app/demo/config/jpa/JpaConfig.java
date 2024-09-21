package app.demo.config.jpa;

import app.demo.domain.secrets.Secret;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaConfig {

    @Bean
    public BasicDataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        Secret model = this.getSecretModel();
        dataSource.setUrl("jdbc:h2:mem:testdb");
        dataSource.setUsername(model.getUser());
        dataSource.setPassword(model.getPassword());
        return dataSource;
    }

    private Secret getSecretModel() {
        return Secret.builder()
                .dbName("CleanArchitecture")
                .host("localhost")
                .password("")
                .port("1433")
                .user("sa")
                .build();
    }
}
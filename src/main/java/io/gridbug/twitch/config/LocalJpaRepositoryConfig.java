package io.gridbug.twitch.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import ch.qos.logback.core.db.dialect.H2Dialect;

@Configuration
@Profile("in-memory")
@EnableJpaRepositories("io.gridbug.twitch.repositories")
public class LocalJpaRepositoryConfig extends AbstractJpaRepositoryConfig {

    protected String getHibernateDialect() {
        return H2Dialect.class.getName();
    }

}

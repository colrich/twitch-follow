package io.gridbug.twitch.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import io.gridbug.twitch.domain.TwitchUser;

public abstract class AbstractJpaRepositoryConfig {

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        return createEntityManagerFactoryBean(dataSource, getHibernateDialect());
    }

    @Bean(name = "transactionManager")
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    protected abstract String getHibernateDialect();

    protected LocalContainerEntityManagerFactoryBean createEntityManagerFactoryBean(DataSource dataSource, String dialectClassName) {
        Map<String, String> properties = new HashMap<String, String>();
        properties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, "update");
        properties.put(org.hibernate.cfg.Environment.DIALECT, dialectClassName);
        properties.put(org.hibernate.cfg.Environment.SHOW_SQL, "true");

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan(TwitchUser.class.getPackage().getName());
        em.setPersistenceProvider(new HibernatePersistence());
        em.setJpaPropertyMap(properties);
        return em;
    }
}

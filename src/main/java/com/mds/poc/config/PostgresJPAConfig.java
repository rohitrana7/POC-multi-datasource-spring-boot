package com.mds.poc.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.mds.poc.psqlrepository",
        entityManagerFactoryRef = "pgEntityManager",
        transactionManagerRef = "pgTransactionManager"
)
public class PostgresJPAConfig {
    @Bean
    LocalContainerEntityManagerFactoryBean pgEntityManager
            (EntityManagerFactoryBuilder builder, @Qualifier("pgDatasource") DataSource dataSource) {
       return builder.dataSource(dataSource).packages("com.mds.poc.psqlentity").build();
    }

    @Bean
    PlatformTransactionManager pgTransactionManager(@Qualifier("pgEntityManager") LocalContainerEntityManagerFactoryBean emfb) {
        return new JpaTransactionManager(emfb.getObject());
    }
}

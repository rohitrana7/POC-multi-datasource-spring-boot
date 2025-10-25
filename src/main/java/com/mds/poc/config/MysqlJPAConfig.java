package com.mds.poc.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.mds.poc.mysqlrepository",
        entityManagerFactoryRef = "mysqlEntityManager",
        transactionManagerRef = "mysqlTransactionManager"
)
public class MysqlJPAConfig {
    @Bean
    LocalContainerEntityManagerFactoryBean mysqlEntityManager
            (EntityManagerFactoryBuilder builder, @Qualifier("mysqlDatasource") DataSource dataSource) {
       return builder.dataSource(dataSource).packages("com.mds.poc.mysqlentity").build();
    }

    @Bean
    PlatformTransactionManager mysqlTransactionManager(@Qualifier("mysqlEntityManager") LocalContainerEntityManagerFactoryBean emfb) {
        return new JpaTransactionManager(emfb.getObject());
    }
}

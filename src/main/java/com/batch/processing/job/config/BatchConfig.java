package com.batch.processing.job.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Value("${spring.profiles.active}")
    private String activeProfile;
    DataSource dataSource;

    public BatchConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public DataSourceInitializer databasePopulator() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        if ("postgres".equalsIgnoreCase(activeProfile)) {
            // For PostgreSQL
            populator.addScript(new ClassPathResource("org/springframework/batch/core/schema-postgresql.sql"));
            populator.addScript(new ClassPathResource("sql/postgres-sql-batch-schema.sql"));
        } else if ("mysql".equalsIgnoreCase(activeProfile)) {
            // For MySQL
            populator.addScript(new ClassPathResource("org/springframework/batch/core/schema-mysql.sql"));
            populator.addScript(new ClassPathResource("sql/mysql-batch-schema.sql"));
        } else {
            // For H2 DB
            populator.addScript(new ClassPathResource("org/springframework/batch/core/schema-h2.sql"));
            populator.addScript(new ClassPathResource("sql/batch-schema.sql"));
        }
        populator.setContinueOnError(false);
        populator.setIgnoreFailedDrops(false);
        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(dataSource);
        dataSourceInitializer.setDatabasePopulator(populator);
        return dataSourceInitializer;
    }
}
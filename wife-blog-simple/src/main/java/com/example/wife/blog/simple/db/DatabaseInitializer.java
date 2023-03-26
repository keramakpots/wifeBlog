package com.example.wife.blog.simple.db;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;

@Configuration
public class DatabaseInitializer {

    private final DataSource dataSource;

    @Value("classpath:db/createTablesQuery.sql")
    private Resource initScript;

    public DatabaseInitializer() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUrl("jdbc:sqlite:/blogDb.sqlite");
        this.dataSource = dataSource;
    }

    @PostConstruct
    public void initialize() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            ScriptUtils.executeSqlScript(connection, initScript, false, false, "--", ";", StandardCharsets.UTF_8);
        }
    }
}

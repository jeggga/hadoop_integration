package ru.serkov.config.hive;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class HiveConfig {

    private final HiveProperties hiveProperties;

    @Bean
    public DataSource hiveDataSource() {
        System.setProperty("java.security.auth.login.config", hiveProperties.getAuthConfigPath());
        System.setProperty("javax.security.auth.useSubjectCredsOnly", hiveProperties.getAuthUseSubjectCredsOnly());
        System.setProperty("java.security.krb5.conf", hiveProperties.getKrb5ConfigPath());
        System.setProperty("sun.security.krb5.debug", hiveProperties.getKrb5Debug());

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(hiveProperties.getUrl());
        hikariConfig.setDriverClassName("org.apache.hive.jdbc.HiveDriver");
        hikariConfig.setConnectionTimeout(hiveProperties.getHikariConnectionTimeout());
        hikariConfig.setMaximumPoolSize(hiveProperties.getHikariMaxPoolSize());
        hikariConfig.setMinimumIdle(hiveProperties.getHikariMinIdle());
        hikariConfig.setMaxLifetime(hiveProperties.getHikariMaxLifetime());

        return new HikariDataSource(hikariConfig);
    }

    @Bean
    public NamedParameterJdbcTemplate hiveJdbcTemplate(@Qualifier("hiveDataSource") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}

package ru.serkov.config.hive;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "app.config.hive")
public class HiveProperties {
    private String url;

    private String authConfigPath;

    private String authUseSubjectCredsOnly;

    private String krb5ConfigPath;

    private String krb5Debug;

    private Long hikariConnectionTimeout;

    private Integer hikariMaxPoolSize;

    private Integer batchSize;

    private Integer hikariMinIdle;

    private Integer hikariMaxLifetime;

    private String schema;

    private String typeOfQueue;

    private String nameOfQueue;
}

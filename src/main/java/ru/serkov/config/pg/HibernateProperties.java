package ru.serkov.config.pg;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "app.config.hibernate")
public class HibernateProperties {
    private String ddlAuto;

    private String showSql;
}

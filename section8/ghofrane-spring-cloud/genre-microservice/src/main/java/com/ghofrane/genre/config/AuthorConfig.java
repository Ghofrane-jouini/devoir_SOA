package com.ghofrane.genre.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "author")
public class AuthorConfig {
    private String name;
    private String email;
}
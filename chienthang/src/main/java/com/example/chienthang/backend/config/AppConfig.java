package com.example.chienthang.backend.config;

import com.example.chienthang.backend.common.Snowflake;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Snowflake snowflake() {
        return new Snowflake(4, 6);
    }
}

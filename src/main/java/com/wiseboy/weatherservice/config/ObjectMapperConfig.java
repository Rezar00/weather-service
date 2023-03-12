package com.wiseboy.weatherservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.TimeZone;

@Configuration
public class ObjectMapperConfig {

    @Bean
    ObjectMapper objectMapper() {
        return new ObjectMapper()
                .findAndRegisterModules()
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .setTimeZone(TimeZone.getTimeZone("UTC"));
    }
}

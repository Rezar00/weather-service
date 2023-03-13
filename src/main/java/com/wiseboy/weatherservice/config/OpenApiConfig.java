package com.wiseboy.weatherservice.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Weather Service")
                        .description("Get your city weather temprature")
                        .version("1.0.0"))
                .externalDocs(new ExternalDocumentation()
                        .description("Source code"));
    }
}

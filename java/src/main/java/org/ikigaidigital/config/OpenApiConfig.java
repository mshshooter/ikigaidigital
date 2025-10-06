package org.ikigaidigital.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI timeDepositOpenAPI() {
        return new OpenAPI().info(new Info().title("Time Deposit API")
                .version("1.0")
                .description("API documentation for Time Deposit App"));
    }
}
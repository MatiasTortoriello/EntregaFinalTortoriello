package com.coderhouse.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Entrega Final - Matías Tortoriello - CoderHouse")
                        .version("1.0")
                        .description("Entrega de TP final del curso de Java de Coderhouse")
                        .contact(new Contact()
                                .name("Matías Tortoriello")))
                .servers(List.of(new Server()
                        .url("http://localhost:8080")
                        .description("Local")));

    }
}
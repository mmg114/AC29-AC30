package com.alkosto.tienda_online.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info=@Info(
                title = "My Api Swagger",
                version = "1.0",
                description = "Documentacion API"
        )
)
public class OpenApiConfig {
}

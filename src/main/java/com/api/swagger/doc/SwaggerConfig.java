package com.api.swagger.doc;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Title - Rest API",
        version = "1.0.0",
        description = "API exemplo de uso de Springboot REST API",
        termsOfService = "Termo de uso: Open Source",
        contact = @Contact(
            name = "C-algaro",
            email = "ti.chrystian@gmail.com"
        ),
        license = @License(
            name = "license",
            url = "http://www.seusite.com.br"
        )
    )
)
public class SwaggerConfig {
    
}

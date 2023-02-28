package com.api.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
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
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

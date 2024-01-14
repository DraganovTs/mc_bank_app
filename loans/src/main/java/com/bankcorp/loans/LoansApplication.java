package com.bankcorp.loans;


import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
        info = @Info(
                title = "Loans microservice REST API Documentation",
                description = "Bank Corp Account microservice REST API Documentation",
                version = "v1",
                contact = @Contact(
                        name = "Draganov",
                        email = "Test@MC.com",
                        url = "http://www.test_microservice.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.test_microservice.com"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Draganov Account microservice REST API Documentation",
                url = "http://www.test_microservice.com"
        )
)
public class LoansApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoansApplication.class);
    }
}

package com.ishi.Doctor.Patient;


import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info =@Info(
                title= "Hospital API",
                description= "Suggesting doctor according to patient symptom",
                version = "3.0.3",
                termsOfService ="T&C",
                contact =@Contact(
                        name ="Ishita",
                        email ="ishita.gupta1005@gmail.com"
                ),
                license = @io.swagger.v3.oas.annotations.info.License(
                        name = "Your License No"
                )
        ),
        servers={
                @Server(
                        description = "Dev",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "Test",
                        url = "http://localhost:8080"
                )
        }
)


public class OpenApiConfig {
}

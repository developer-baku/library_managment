package org.services.library_management;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryManagementApplication {
    @Bean
    public OpenAPI api(){
        return new OpenAPI().info(new Info().title("Library Management API").description("This is REST API for Library Management").version("v1.0")
                ).externalDocs(new ExternalDocumentation().description("You can refer to the documentation of Spring doc OpenApi").url("https://springdoc.org/#Introduction"));
    }

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementApplication.class, args);
    }

}

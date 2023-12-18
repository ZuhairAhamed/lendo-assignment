package com.lendo.assignment.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Value("${openapi.dev-url}")
    private String devUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL for Development environment");

        Contact contact = new Contact();
        contact.setEmail("zuhairahamed4@gmail.com");
        contact.setName("Zuhair Ahamed");

        Info info = new Info()
                .title("Lendo Test API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to Lendo assignment.");

        return new OpenAPI().info(info).servers(List.of(devServer));
    }

}

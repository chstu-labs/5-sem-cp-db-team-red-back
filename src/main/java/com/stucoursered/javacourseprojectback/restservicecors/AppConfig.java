package com.stucoursered.javacourseprojectback.restservicecors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// To enable CORS, uncomment the following imports:
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig {

    // Uncomment this to enable CORS
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "PUT", "DELETE");
                ;
            }
        };
    }
}

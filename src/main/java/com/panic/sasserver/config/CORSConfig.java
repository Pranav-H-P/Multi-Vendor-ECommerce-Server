package com.panic.sasserver.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig {

    private final String frontendLink = "http://localhost:4200/";

    @Bean
    public WebMvcConfigurer CorsConfigBean(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/api/**").allowedOrigins(frontendLink)
                        .allowedMethods(
                                HttpMethod.GET.name(),
                                HttpMethod.POST.name(),
                                HttpMethod.DELETE.name()
                        ).allowedHeaders(
                                HttpHeaders.CONTENT_TYPE,
                                HttpHeaders.AUTHORIZATION
                        );

            }
        };
    }
}

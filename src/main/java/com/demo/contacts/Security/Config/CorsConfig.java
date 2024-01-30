package com.demo.contacts.Security.Config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsConfig implements WebMvcConfigurer {

    //configuration of cors to accept requests from front-end
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")//this affects all routes api
                .allowedOrigins("*")//accepts all routes external
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("origin", "Content-Type", "Accept", "Authorization")
                .allowCredentials(true)
                .maxAge(3600);

        registry.addMapping("/auth/**")//this only route login
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("origin", "Content-Type", "Accept", "Authorization")
                .allowCredentials(false)
                .maxAge(3600);

    }
}

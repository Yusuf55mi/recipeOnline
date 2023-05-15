package com.yusuf.recipeOnline.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("http://localhost:8080/user/register")
                .allowedOrigins("*")
                .allowedMethods("POST")
                .allowedHeaders("*");
    }

}

package com.address.book.addressbookapi.corsconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {
    Logger logger = LoggerFactory.getLogger(WebConfig.class);

    @Bean
    public WebMvcConfigurer getCorsConfiguration() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                logger.info("We are in the addCorsMappings inside the WebConfig");
                registry.addMapping("/customer/*")
                        .allowedOrigins("http://10.50.2.211:8081")
                        .allowedMethods("GET", "POST")
                        .allowCredentials(true).maxAge(3600);
            }
        };
    }
}




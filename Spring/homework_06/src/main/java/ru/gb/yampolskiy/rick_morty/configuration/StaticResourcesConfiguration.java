package ru.gb.yampolskiy.rick_morty.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class StaticResourcesConfiguration implements WebMvcConfigurer {
//    public static final String API_ENDPOINT_CHARACTER ="https://rickandmortyapi.com/api/character/";
//    public static final String API_ENDPOINT_LOCATION ="https://rickandmortyapi.com/api/location/";
//    public static final String API_ENDPOINT_EPISODE ="https://rickandmortyapi.com/api/episode/";
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/styles/css/**")
                .addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/images/**")
                .addResourceLocations("classpath:/static/images/");

    }
}

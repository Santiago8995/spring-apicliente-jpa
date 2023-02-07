package com.agora.clienteservice.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
@EnableWebMvc
public class WebMvcCustomConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){

        if (!registry.hasMappingForPattern("/api/**")) {
            registry.addResourceHandler("/api/**")
                    .addResourceLocations("classpath:/api/");
        }
    }

    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){configurer.enable();}

}


package com.stoneCod.Barberia.autenticacion;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public  void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/home").setViewName("empresa");
        registry.addViewController("/").setViewName("empresa");
        registry.addViewController("/empresa").setViewName("empresa");
        registry.addViewController("/login").setViewName("login");
    }
}

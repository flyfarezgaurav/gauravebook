package com.travel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@org.springframework.boot.autoconfigure.SpringBootApplication 
public class SpringBootApplication extends SpringBootServletInitializer implements WebMvcConfigurer{

	public static void main(String[] args) { 
	
		SpringApplication.run(SpringBootApplication.class, args);
	} 

/*	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
		registry
        .addResourceHandler("/resources/**") 
        .addResourceLocations("/resources/");
       
      
    }*/  
	
	@Override
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	  return application.sources(SpringBootApplication.class); 
	 }
	
	
	}

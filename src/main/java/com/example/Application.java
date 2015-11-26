package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@ComponentScan
@EnableAutoConfiguration
public class Application extends SpringBootServletInitializer
{

    public static void main( String[] args )    {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    	
        return application.sources(appClass);
    }

    private static Class<Application> appClass = Application.class;
    
    @Bean
    public HttpSessionEventPublisher sessionEventPublisher(){
    	return new HttpSessionEventPublisher();
    }
}

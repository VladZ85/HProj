package com.haulmont.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Vlad on 23-Feb-17.
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan(("com.haulmont"))
//@EnableJpaRepositories(("com.haulmont"))
//@EntityScan(("com.haulmont"))
public class SpringBootApplication extends SpringBootServletInitializer {

    protected SpringApplicationBuilder configure (SpringApplicationBuilder application)  {
        return application.sources(SpringBootApplication.class);
    }

    public static void main (String args) {
        SpringApplication.run(SpringBootApplication.class, args);
    }

}

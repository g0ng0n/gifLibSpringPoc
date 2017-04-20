package com.test.project.giflib.config;

import org.hashids.Hashids;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by g0ng0n.
 */

@Configuration
@PropertySource("app.properties")
public class AppConfig {

    @Autowired
    private Environment env;

    @Bean
    public Hashids hashids(){
        return new Hashids(env.getProperty("giflib.hash.salt"),8);
    }

}

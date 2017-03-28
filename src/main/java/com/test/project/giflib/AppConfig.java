package com.test.project.giflib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by gonzalo.gisbert on 27/03/17.
 */
@EnableAutoConfiguration
@ComponentScan
public class AppConfig {
   public static void  main (String[] args){
       SpringApplication.run(AppConfig.class, args);

   }
}

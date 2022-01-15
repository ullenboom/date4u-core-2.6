package com.tutego.date4u;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Date4uApplication {

  public static void main( String[] args ) {
    ApplicationContext ctx = SpringApplication.run( Date4uApplication.class, args );
  }

}

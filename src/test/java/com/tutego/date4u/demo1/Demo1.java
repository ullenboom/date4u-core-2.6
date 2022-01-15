package com.tutego.date4u.demo1;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

//@Component
//class DateAtStartTime implements ApplicationRunner {
//
//  @Override
//  public void run( ApplicationArguments args ) throws Exception {
//    System.out.println( LocalDateTime.now() );
//    // nonoption --option1=value1 --option2=value2 --option3
//    System.out.println( args.getNonOptionArgs() );
//    System.out.println( args.getOptionNames() );
//    System.out.println( Arrays.toString( args.getSourceArgs() ) );
//    for ( String optionName : args.getOptionNames() ) {
//      System.out.println( args.getOptionValues( optionName ) );
//    }
//  }
//}

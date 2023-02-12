package com.promineotech.jeep;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class JeepSales {
  
  
  
  public static void main(String[] args) {
   System.out.println("First sysout in Main");
    SpringApplication.run(JeepSales.class, args);
    System.out.println("Second sysout in Main");
    
  }

}

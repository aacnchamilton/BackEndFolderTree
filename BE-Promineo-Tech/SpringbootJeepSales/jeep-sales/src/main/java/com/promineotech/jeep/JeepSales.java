package com.promineotech.jeep;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
//@OpenAPIDefinition(info = @Info(title = "Jeep Sales Service"))
@ComponentScan({"com.promineotech.jeep.controller"})
@ComponentScan({"com.promineotech.jeep.entity"})
public class JeepSales {
  
  
  
  public static void main(String[] args) {
   System.out.println("First sysout in Main");
    SpringApplication.run(JeepSales.class, args);
    System.out.println("Second sysout in Main");
    
  }

}

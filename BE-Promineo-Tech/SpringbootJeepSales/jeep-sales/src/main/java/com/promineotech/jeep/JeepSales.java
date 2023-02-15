package com.promineotech.jeep;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;

@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class})
public class JeepSales {
  
  public static void main(String[] args) {

    SpringApplication.run(JeepSales.class, args);
    
  }

}

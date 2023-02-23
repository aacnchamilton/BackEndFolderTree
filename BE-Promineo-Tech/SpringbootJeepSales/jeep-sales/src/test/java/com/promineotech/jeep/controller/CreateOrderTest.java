package com.promineotech.jeep.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = {
    "classpath:flyway/migrations/V1.0__Jeep_Schema.sql",
    "classpath:flyway/migrations/V1.1__Jeep_Data.sql"},
    config = @SqlConfig(encoding = "utf-8"))
public class CreateOrderTest {
  
  @Test
  void testCreateOrderReturnsSuccess201() {
    //Given: an order as JSON
    String body = createOrderBody();
    
    //When: the order is sent
    
    //Then: a 201 status is returned
    
    //And: the returned order is correct
  }
  
   String createOrderBody() {  //Got the idea to do this from riptutorial.com

     String json = "{\n"
         + " \"customer\":\"ATTAWAY_HECKTOR\",\n"
         + " \"model\":\"WRANGLER\",\n"
         + " \"trim\":\"Rubicon\",\n"
         + " \"doors\":\"4\",\n"
         + " \"color\":\"EXT_GLACIER_METALLIC\",\n"
         + " \"engine\":\"6_4_GAS\",\n"
         + " \"tire\":\"35_NITTO_MT\",\n"
         + " \"options\":[\n"
         + "     \"TOP_MOPAR_HARD_3_COLOR\",\n"
         + "     \"DOOR_QUAD_4\",\n"
         + "     \"EXT_MOPAR_SLIDER\",\n"
         + "     \"EXT_MOPAR_TRAILER\",\n"
         + "     \"EXT_MOPAR_HEAD_LED\",\n"
         + "     \"EXT_WARN_WINCH\",\n"
         + "     \"EXT_AEV_LIFT\",\n"
         + "     \"EXT_ROUGH_WINCH\",\n"
         + "     \"INT_MOPAR_GRAB\"\n"
         + "     ]\n"
         + " }";

    return json;
    
  }

}

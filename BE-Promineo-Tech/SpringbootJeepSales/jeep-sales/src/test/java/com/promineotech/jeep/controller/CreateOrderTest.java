package com.promineotech.jeep.controller;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import com.promineotech.jeep.entity.JeepModel;
import com.promineotech.jeep.entity.Order;
import lombok.Getter;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = {
    "classpath:flyway/migrations/V1.0__Jeep_Schema.sql",
    "classpath:flyway/migrations/V1.1__Jeep_Data.sql"},
    config = @SqlConfig(encoding = "utf-8"))


public class CreateOrderTest {
  
  @LocalServerPort
  private int serverPort;
  @Autowired
  @Getter
  private TestRestTemplate restTemplate;
  
  @Test
  void testCreateOrderReturnsSuccess201() {
    //Given: an order as JSON
    String body = createOrderBody();
    String uri = String.format("http://localhost:%d/orders", serverPort);
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> bodyEntity = new HttpEntity<>(body, headers);
    
    //When: the order is sent
    ResponseEntity<Order> response = restTemplate.exchange(uri,HttpMethod.POST, bodyEntity, Order.class);

    //Then: a 201 status is returned
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    assertThat(response.getBody()).isNotNull();

    Order order = response.getBody();
    assertThat(order.getCustomer().getCustomerId()).isEqualTo("ATTAWAY_HECKTOR");
    assertThat(order.getModel().getModelId()).isEqualTo(JeepModel.WRANGLER);
    assertThat(order.getModel().getTrimLevel()).isEqualTo("Rubicon");
    assertThat(order.getModel().getNumDoors()).isEqualTo(4);
    assertThat(order.getColor().getColorId()).isEqualTo("EXT_GLACIER_METALLIC");
    assertThat(order.getEngine().getEngineId()).isEqualTo("6_4_GAS");
    assertThat(order.getTire().getTireId()).isEqualTo("35_NITTO_MT");
    assertThat(order.getOptions()).hasSize(9);

    

    
    //Then: a 201 status is returned
    
    //And: the returned order is correct
  }
  
   String createOrderBody() {

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

package com.promineotech.jeep.controller;


import static org.assertj.core.api.Assertions.assertThat;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;
import lombok.Getter;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = {
    "classpath:flyway/migrations/V1.0__Jeep_Schema.sql",
    "classpath:flyway/migrations/V1.1__Jeep_Data.sql"},
    config = @SqlConfig(encoding = "utf-8"))
class FetchJeepTest {
  @Autowired
  @Getter
  private TestRestTemplate restTemplate;
  @LocalServerPort
  private int serverPort;
  
  @Test
  void testThatJeepsAreReturnedWhenAValidModelAndTrimAreSupplied() {
  //Given a valid model, trim and URI
      JeepModel model = JeepModel.WRANGLER;
      String trim = "Sport";
      String uri = String.format("http://localhost:%d/jeeps?model=%s&trim=%s", serverPort, model, trim);
      
      System.out.println("From FetchJeepTest: " + uri);
      
      //When a connection is made to the URI
      ResponseEntity<List<Jeep>> response =  restTemplate.exchange(uri,HttpMethod.GET,null, 
          new ParameterizedTypeReference<>() {});
      
      //Then a status code 200 is returned
      assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
      List<Jeep> expected = buildExpected();
      List<Jeep> actual = response.getBody();
      System.out.println("buildExpected: " + expected + ", response.getBody(): " + actual);
      
      assertThat(actual).isEqualTo(expected);
  }

  private List<Jeep> buildExpected() {
        List<Jeep> list = new LinkedList<>(); 
        list.add(Jeep.builder()
            .modelId(JeepModel.WRANGLER)
            .trimLevel("Sport")
            .numDoors(2)
            .wheelSize(17)
            .basePrice(new BigDecimal("28475.00"))
            .build());
        list.add(Jeep.builder()
            .modelId(JeepModel.WRANGLER)
            .trimLevel("Sport")
            .numDoors(4)
            .wheelSize(17)
            .basePrice(new BigDecimal("31975.00"))
            .build());
        return list;
    
  }

}

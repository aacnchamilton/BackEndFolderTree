package com.promineotech.jeep.entity;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Jeep {

  private Long modelPk;
  private JeepModel modelId;
  String trimLevel;
  int numDoors;
  int wheelSize;
  BigDecimal basePrice;
  
}

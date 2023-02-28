package com.promineotech.jeep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.jeep.dao.JeepOrderDao;
import com.promineotech.jeep.entity.Order;
import com.promineotech.jeep.entity.OrderRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DefaultJeepOrderService implements JeepOrderService {
  
  @Autowired
  private JeepOrderDao jeepOrderDao;
  
  @Override
  public
  Order createOrder(OrderRequest orderRequest) {
    log.info("DefaultJeepOrderService.createOrder: {}", orderRequest);
    return jeepOrderDao.createOrder(orderRequest);
  }
}

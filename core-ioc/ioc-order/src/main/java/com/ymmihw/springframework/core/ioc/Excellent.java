package com.ymmihw.springframework.core.ioc;

import org.springframework.stereotype.Component;
import org.springframework.core.annotation.Order;

@Component
@Order(1)
public class Excellent implements Rating {

  @Override
  public int getRating() {
    return 1;
  }
}

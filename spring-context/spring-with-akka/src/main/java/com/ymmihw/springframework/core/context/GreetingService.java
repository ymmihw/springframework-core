package com.ymmihw.springframework.core.context;

import org.springframework.stereotype.Component;

@Component
public class GreetingService {

  public String greet(String name) {
    return "Hello, " + name;
  }

}

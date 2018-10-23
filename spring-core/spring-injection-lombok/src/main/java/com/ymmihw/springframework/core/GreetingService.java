package com.ymmihw.springframework.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GreetingService {

  @Autowired
  private Translator translator;

  public String greet() {
    return translator.translate("hello");
  }
}

package com.ymmihw.springframework.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomAnnotationIntegrationTest {

  @Autowired
  private Service service;

  @Test
  public void shouldApplyCustomAnnotation() throws InterruptedException {
    service.serve();
  }

}

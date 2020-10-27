package com.ymmihw.springframework.beans;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.annotation.PostConstruct;

@Configuration
public class InjectingObjectProviderExample {

  @Bean
  ClientBean clientBean() {
    return new ClientBean();
  }

  @Bean
  ExampleBean exampleBean() {
    return new ExampleBean();
  }

  public static void main(String[] args) {
    new AnnotationConfigApplicationContext(InjectingObjectProviderExample.class);
  }

  private static class ClientBean {
    @Autowired
    ObjectProvider<ExampleBean> objectProvider;

    @PostConstruct
    void postConstruct() {
      if (objectProvider != null) {
        ExampleBean exampleBean = objectProvider.getObject();
        if (exampleBean != null) {
          exampleBean.doSomething();
        }
      }
    }
  }
}

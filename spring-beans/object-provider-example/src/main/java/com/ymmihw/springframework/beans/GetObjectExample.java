package com.ymmihw.springframework.beans;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetObjectExample {
  @Bean
  ExampleBean exampleBean() {
    return new ExampleBean();
  }

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(GetObjectExample.class);
    ObjectProvider<ExampleBean> beanProvider = context.getBeanProvider(ExampleBean.class);
    ExampleBean exampleBean = beanProvider.getObject();
    exampleBean.doSomething();
  }
}

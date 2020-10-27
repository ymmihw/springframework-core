package com.ymmihw.springframework.beans;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class GetObjectWithArgsExample {
  @Bean
  @Lazy
  ExampleBean2 exampleBean(String arg) {
    return new ExampleBean2(arg);
  }

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(GetObjectWithArgsExample.class);
    ObjectProvider<ExampleBean2> beanProvider = context.getBeanProvider(ExampleBean2.class);
    ExampleBean2 exampleBean = beanProvider.getObject("test arg");
    exampleBean.doSomething();
  }
}

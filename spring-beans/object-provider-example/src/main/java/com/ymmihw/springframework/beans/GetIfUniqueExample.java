package com.ymmihw.springframework.beans;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetIfUniqueExample {

  @Bean
  ExampleBean exampleBean() {
    return new ExampleBean();
  }

  // uncomment following then getIfUnique will return null

  // @Bean
  // ExampleBean exampleBean2() {
  // return new ExampleBean();
  // }


  public static void main(String[] args) {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(GetIfUniqueExample.class);
    ObjectProvider<ExampleBean> beanProvider = context.getBeanProvider(ExampleBean.class);
    ExampleBean exampleBean = beanProvider.getIfUnique();
    System.out.println("example bean: " + exampleBean);
    if (exampleBean != null) {
      exampleBean.doSomething();
    }
  }
}

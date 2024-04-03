package com.ymmihw.springframework.factory;

import static org.junit.jupiter.api.Assertions.assertNotSame;

import com.ymmihw.springframework.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@SpringBootTest
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class FactoryBeanTest {

  @Autowired private ObjectFactory<Employee> factory;


  @Test
  public void givenPrototypeBean_WhenObjectProvider_ThenNewInstanceReturn() {
    Employee firstInstance = factory.getObject();
    Employee secondInstance = factory.getObject();
    assertNotSame(firstInstance, secondInstance);
  }

  @Configuration
  @ComponentScan(basePackages = {"com.ymmihw.springframework.factory"})
  static class ContextConfiguration {
    @Bean
    @Scope(value = "prototype")
    public Employee employee() {
      return new Employee();
    }
  }
}

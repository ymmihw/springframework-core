package com.ymmihw.springframework.function;

import static org.junit.jupiter.api.Assertions.assertNotSame;

import com.ymmihw.springframework.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.core.internal.Function;
import org.springframework.context.annotation.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@SpringBootTest
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class FunctionBeanUnitTest {
  @Autowired private EmployeeBeanUsingFunction function;

  @Test
  public void givenPrototypeBean_WhenObjectProvider_ThenNewInstanceReturn() {
    Employee firstInstance = function.getEmployee("sachin");
    Employee secondInstance = function.getEmployee("kumar");
    assertNotSame(firstInstance, secondInstance);
  }

  @Configuration
  @ComponentScan(basePackages = {"com.ymmihw.springframework.function"})
  static class ContextConfiguration {

    @Bean
    public Function<String, Employee> beanFactory() {
      return name -> new Employee(name);
    }
  }
}

package com.ymmihw.springframework.objectprovider;

import static org.junit.jupiter.api.Assertions.assertNotSame;

import com.ymmihw.springframework.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@SpringBootTest
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class ObjectProviderBeanUnitTest {
  @Autowired private EmployeeBeanUsingObjectProvider objectProvider;

  @Test
  public void givenPrototypeBean_WhenObjectProvider_ThenNewInstanceReturn() {
    Employee firstInstance = objectProvider.getEmployee("sachin");
    Employee secondInstance = objectProvider.getEmployee("kumar");
    assertNotSame(firstInstance, secondInstance);
  }

  @Configuration
  @ComponentScan(basePackages = {"com.ymmihw.springframework.objectprovider"})
  static class ContextConfiguration {
    @Bean
    @Scope(value = "prototype")
    public Employee employee(String name) {
      return new Employee(name);
    }
  }
}

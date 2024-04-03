package com.ymmihw.springframework.factory;

import com.ymmihw.springframework.Employee;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeBeanUsingObjectFactory {

  @Autowired private ObjectFactory<Employee> employeeObjectFactory;

  public Employee getEmployee() {
    return employeeObjectFactory.getObject();
  }
}

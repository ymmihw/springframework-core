package com.ymmihw.springframework.core.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.ymmihw.springframework.core.domain.Employee;

@Component
public class StringToEmployeeConverter implements Converter<String, Employee> {

  @Override
  public Employee convert(String from) {
    String[] data = from.split(",");
    return new Employee(Long.parseLong(data[0]), Double.parseDouble(data[1]));
  }
}

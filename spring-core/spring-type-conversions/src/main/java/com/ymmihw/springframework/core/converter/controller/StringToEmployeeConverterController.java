package com.ymmihw.springframework.core.converter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ymmihw.springframework.core.domain.Employee;

@RestController
public class StringToEmployeeConverterController {

  @GetMapping("/string-to-employee")
  public ResponseEntity<Object> getStringToEmployee(@RequestParam("employee") Employee employee) {
    return ResponseEntity.ok(employee);
  }
}

package com.ymmihw.springframework;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Employee {

  private String name;

  public void printName() {
    System.out.println(name);
  }
}

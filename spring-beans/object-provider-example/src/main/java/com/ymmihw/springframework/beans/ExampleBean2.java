package com.ymmihw.springframework.beans;

public class ExampleBean2 {
  private String arg;

  public ExampleBean2(String arg) {
    this.arg = arg;
  }

  public void doSomething() {
    System.out.println("in example bean2, arg: " + arg);
  }
}

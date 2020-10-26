package com.ymmihw.springframework;

public class BeanB {
  private BeanA beanA;

  BeanB(BeanA beanA) {
    this.beanA = beanA;
  }

  public BeanA getBeanA() {
    return beanA;
  }
}

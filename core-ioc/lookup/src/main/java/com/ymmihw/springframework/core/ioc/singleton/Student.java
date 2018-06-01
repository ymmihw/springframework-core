package com.ymmihw.springframework.core.ioc.singleton;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component("studentBean")
public class Student {

  @Lookup
  public SchoolNotification getNotification() {
    // spring overrides and returns a SchoolNotification instance
    return null;
  }
}

package com.ymmihw.springframework.core.ioc.procedurally;

import java.util.HashMap;
import java.util.Map;

public abstract class StudentServices {

  private Map<String, SchoolNotification> notes = new HashMap<>();

  protected abstract SchoolNotification getNotification(String name);

  public String appendMark(String name, Integer mark) {
    SchoolNotification notification = notes.computeIfAbsent(name, exists -> getNotification(name));
    return notification.addMark(mark);
  }
}

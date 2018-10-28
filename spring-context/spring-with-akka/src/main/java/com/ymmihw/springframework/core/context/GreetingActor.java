package com.ymmihw.springframework.core.context;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import akka.actor.AbstractActor;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GreetingActor extends AbstractActor {

  private GreetingService greetingService;

  public GreetingActor(GreetingService greetingService) {
    this.greetingService = greetingService;
  }

  public static class Greet {

    private String name;

    public Greet(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }
  }

  @Override
  public Receive createReceive() {
    return receiveBuilder().match(Greet.class, d -> {
      getSender().tell(greetingService.greet(d.getName()), getSelf());
    }).matchAny(d -> unhandled(d)).build();
  }
}

package com.ymmihw.springframework.core.context;

import org.springframework.context.ApplicationContext;
import akka.actor.AbstractExtensionId;
import akka.actor.ExtendedActorSystem;
import akka.actor.Extension;
import akka.actor.Props;

public class SpringExtensionId extends AbstractExtensionId<SpringExtensionId.SpringExtension> {

  public static final SpringExtensionId SPRING_EXTENSION_PROVIDER = new SpringExtensionId();

  @Override
  public SpringExtension createExtension(ExtendedActorSystem system) {
    return new SpringExtension();
  }

  public static class SpringExtension implements Extension {

    private volatile ApplicationContext applicationContext;

    public void initialize(ApplicationContext applicationContext) {
      this.applicationContext = applicationContext;
    }

    public Props props(String actorBeanName) {
      return Props.create(SpringActorProducer.class, applicationContext, actorBeanName);
    }
  }

  private SpringExtensionId() {}
}

package com.ymmihw.springframework.core.context;

import static akka.pattern.Patterns.ask;
import static com.ymmihw.springframework.core.context.SpringExtensionId.SPRING_EXTENSION_PROVIDER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import com.ymmihw.springframework.core.context.GreetingActor.Greet;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.util.Timeout;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.FiniteDuration;

@SpringBootTest(classes = AppConfiguration.class)
public class SpringAkkaIntegrationTest extends AbstractJUnit4SpringContextTests {

  @Autowired
  private ActorSystem system;

  @Test
  public void whenCallingGreetingActor_thenActorGreetsTheCaller() throws Exception {
    ActorRef greeter =
        system.actorOf(SPRING_EXTENSION_PROVIDER.get(system).props("greetingActor"), "greeter");

    FiniteDuration duration = FiniteDuration.create(1, TimeUnit.SECONDS);
    Timeout timeout = Timeout.durationToTimeout(duration);

    Future<Object> result = ask(greeter, new Greet("John"), timeout);

    assertEquals("Hello, John", Await.result(result, duration));
  }

  @AfterEach
  public void tearDown() {
    system.terminate();
  }
}

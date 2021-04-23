package com.ymmihw.springframework.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@SpringBootTest
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = TestConfig.class)
public class GreetingServiceIntegrationTest {

  @Autowired
  private GreetingService greetingService;

  @Autowired
  private Translator translator;

  @Test
  public void greetWithTranslatedMessage() {
    String translated = "translated";
    when(translator.translate("hello")).thenReturn(translated);
    assertEquals(translated, greetingService.greet());
  }

  @Test
  public void throwWhenInstantiated() {
    GreetingService greetingService = new GreetingService();

    assertThrows(NullPointerException.class, () -> greetingService.greet());
  }
}

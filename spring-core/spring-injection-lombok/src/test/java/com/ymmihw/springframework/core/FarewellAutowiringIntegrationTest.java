package com.ymmihw.springframework.core;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = TestConfig.class)
public class FarewellAutowiringIntegrationTest {

  @Autowired
  private FarewellService farewellService;

  @Autowired
  private Translator translator;

  @Test
  public void sayByeWithTranslatedMessage() {
    String translated = "translated";
    when(translator.translate("bye")).thenReturn(translated);
    assertEquals(translated, farewellService.farewell());
  }
}

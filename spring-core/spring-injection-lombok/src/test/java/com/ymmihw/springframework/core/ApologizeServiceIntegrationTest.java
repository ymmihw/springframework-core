package com.ymmihw.springframework.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ApologizeServiceIntegrationTest {

  private final static String MESSAGE = "MESSAGE";
  private final static String TRANSLATED = "TRANSLATED";

  @Test
  public void apologizeWithCustomTranslatedMessage() {
    Translator translator = mock(Translator.class);
    ApologizeService apologizeService = new ApologizeService(translator, MESSAGE);
    when(translator.translate(MESSAGE)).thenReturn(TRANSLATED);
    assertEquals(TRANSLATED, apologizeService.apologize());
  }
}

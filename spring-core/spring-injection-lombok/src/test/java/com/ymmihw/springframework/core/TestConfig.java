package com.ymmihw.springframework.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import static org.mockito.Mockito.mock;

@Configuration
@ComponentScan("com.ymmihw.springframework.core")
class TestConfig {

  @Bean
  public Translator mockTranslator() {
    return mock(Translator.class);
  }
}

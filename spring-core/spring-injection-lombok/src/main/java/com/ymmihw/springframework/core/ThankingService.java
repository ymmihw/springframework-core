package com.ymmihw.springframework.core;

import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ThankingService {

  private final Translator translator;

  public String thank() {
    return translator.translate("thank you");
  }
}

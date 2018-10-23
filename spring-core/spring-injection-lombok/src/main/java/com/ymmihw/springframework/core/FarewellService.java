package com.ymmihw.springframework.core;

import org.springframework.stereotype.Component;

@Component
public class FarewellService {

  private final Translator translator;

  public FarewellService(Translator translator) {
    this.translator = translator;
  }

  public String farewell() {
    return translator.translate("bye");
  }
}

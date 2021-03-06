package com.ymmihw.springframework.core.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

@Component
public class StringToEnumConverterFactory implements ConverterFactory<String, Enum<?>> {

  private static class StringToEnumConverter<T extends Enum<T>> implements Converter<String, T> {

    private Class<T> enumType;

    public StringToEnumConverter(Class<T> enumType) {
      this.enumType = enumType;
    }

    @Override
    public T convert(String source) {
      return Enum.valueOf(this.enumType, source.trim());
    }
  }

  // TODO unchecked & rawtypes
  @SuppressWarnings({"unchecked", "rawtypes"})
  @Override
  public <T extends Enum<?>> Converter<String, T> getConverter(Class<T> targetType) {
    return new StringToEnumConverter(targetType);
  }
}

package com.ymmihw.springframework.core.converter;

import com.google.common.collect.ImmutableSet;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.Set;

@Component

public class GenericBigDecimalConverter implements GenericConverter {

  @Override
  public Set<ConvertiblePair> getConvertibleTypes() {
    ConvertiblePair[] pairs =
        new ConvertiblePair[] {new ConvertiblePair(Number.class, BigDecimal.class),
            new ConvertiblePair(String.class, BigDecimal.class)};
    return ImmutableSet.copyOf(pairs);
  }

  @Override
  public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
    if (sourceType.getType() == BigDecimal.class) {
      return source;
    }
    if (sourceType.getType() == String.class) {
      String number = (String) source;
      return new BigDecimal(number);
    } else {
      Number number = (Number) source;
      BigDecimal converted = new BigDecimal(number.doubleValue());
      return converted.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }
  }
}

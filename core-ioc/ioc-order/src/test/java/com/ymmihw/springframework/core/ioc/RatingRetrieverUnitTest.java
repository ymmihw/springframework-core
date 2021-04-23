package com.ymmihw.springframework.core.ioc;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@SpringBootTest
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class RatingRetrieverUnitTest {

  @Configuration
  @ComponentScan(basePackages = {"com.ymmihw.springframework.core.ioc"})
  static class ContextConfiguration {
  }

  @Autowired
  private List<Rating> ratings;

  @Test
  public void givenOrderOnComponents_whenInjected_thenAutowireByOrderValue() {
    assertThat(ratings.get(0).getRating(), is(equalTo(1)));
    assertThat(ratings.get(1).getRating(), is(equalTo(2)));
    assertThat(ratings.get(2).getRating(), is(equalTo(3)));
  }

}

package com.ymmihw.springframework.core.ioc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.ymmihw.springframework.core.ioc.procedurally.StudentServices;
import com.ymmihw.springframework.core.ioc.singleton.Student;

public class StudentTest {

  @Test
  public void whenLookupMethodCalled_thenNewInstanceReturned() {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class);
    Student student1 = context.getBean("studentBean", Student.class);
    Student student2 = context.getBean("studentBean", Student.class);

    Assert.assertEquals(student1, student2);
    Assert.assertNotEquals(student1.getNotification(), student1.getNotification());
    context.close();
  }

  @Test
  public void whenAbstractGetterMethodInjects_thenNewInstanceReturned() {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    StudentServices services = context.getBean("studentServices", StudentServices.class);

    Assert.assertEquals("PASS", services.appendMark("Alex", 76));
    Assert.assertEquals("FAIL", services.appendMark("Bethany", 44));
    Assert.assertEquals("PASS", services.appendMark("Claire", 96));
    context.close();
  }
}

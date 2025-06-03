package com.java.spring_dasar;

import com.java.spring_dasar.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanNameTest {
    private ApplicationContext applicationContextl;

    @BeforeEach
    void setUp() {
        applicationContextl = new AnnotationConfigApplicationContext(BeanNameConfiguration.class);
    }

    @Test
    void testBeanName() {
        Foo foo = applicationContextl.getBean(Foo.class);
        Foo fooFirst = applicationContextl.getBean("fooFirst", Foo.class);
        Foo fooSecond = applicationContextl.getBean("fooSecond", Foo.class);

        Assertions.assertSame(foo, fooFirst);
        Assertions.assertNotSame(fooFirst, fooSecond);
        Assertions.assertNotSame(foo, fooSecond);
    }

}

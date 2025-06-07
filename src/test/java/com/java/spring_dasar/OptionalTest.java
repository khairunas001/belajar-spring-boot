package com.java.spring_dasar;

import com.java.spring_dasar.data.Foo;
import com.java.spring_dasar.data.FooBar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OptionalTest {

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(OptionalConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testOptional() {
        Foo foo = applicationContext.getBean(Foo.class);
        FooBar fooBar = applicationContext.getBean(FooBar.class);

        // karena Bar bean yang optional dan jika tidak ada akan diisi dengan null sesuai dengan konfigurasi
        Assertions.assertNull(fooBar.getBar());

        // nilainya harus sama
        Assertions.assertSame(foo, fooBar.getFoo());
    }
}

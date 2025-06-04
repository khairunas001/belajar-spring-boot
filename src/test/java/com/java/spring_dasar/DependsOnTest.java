package com.java.spring_dasar;

import com.java.spring_dasar.data.Foo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DependsOnTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    void setup() {
        applicationContext = new AnnotationConfigApplicationContext(DependsOnConfiguration.class);
    }

    @Test
    void testDependsOn() {
        // jika tidak fipanggil Bean Foo nya maka tidak akan dibuat

        // dan jika ingin dibuat seperti pada kode dibawah
        Foo foo = applicationContext.getBean(Foo.class);
    }
}

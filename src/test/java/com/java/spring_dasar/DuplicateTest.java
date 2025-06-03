package com.java.spring_dasar;

import com.java.spring_dasar.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DuplicateTest {

    @Test
    void testDuplicate() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DuplicateConfiguration.class);

        // NoUniqueBeanDefinitionException: No qualifying bean of type 'com.java.spring_dasar.data.Foo'
        // available: expected single matching bean but found 2: foo1,foo2
        // Foo foo = context.getBean(Foo.class);

        Assertions.assertThrows(NoSuchBeanDefinitionException.class,()->{
           Foo foo = context.getBean(Foo.class);
        });
    }


    @Test
    void  getBean(){
        ApplicationContext context = new AnnotationConfigApplicationContext(DuplicateConfiguration.class);

        // untuk mengaksesn beberapa bean dalam 1 class dapat menambahkan namabeansnya dengan menggunakan tanda kutip
        // "****" seperti pada contoh dibawah
        Foo foo1 = context.getBean("foo1", Foo.class);
        Foo foo2 = context.getBean("foo2", Foo.class);

        Assertions.assertNotSame(foo1,foo2);

    }
}

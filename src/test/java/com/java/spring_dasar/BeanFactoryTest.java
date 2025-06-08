package com.java.spring_dasar;

import com.java.spring_dasar.data.Bar;
import com.java.spring_dasar.data.Foo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BeanFactoryTest {

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp (){
        applicationContext = new AnnotationConfigApplicationContext(ScanConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testBeanFactory(){
        ObjectProvider<Foo> fooObjectProvider = applicationContext.getBeanProvider(Foo.class);
        ObjectProvider<Bar> barObjectProvider = applicationContext.getBeanProvider(Bar.class);

        List<Foo> fooList = fooObjectProvider.stream().collect(Collectors.toList());
        List<Bar> barList = barObjectProvider.stream().collect(Collectors.toList());

        System.out.println(fooList);
        System.out.println(barList);
        // output = [com.java.spring_dasar.data.Foo@2072acb2, com.java.spring_dasar.data.Foo@50ecde95, com.java.spring_dasar.data.Foo@35a9782c]

        Map<String, Foo> beansOfType1 = applicationContext.getBeansOfType(Foo.class);
        Map<String, Bar> beansOfType2 = applicationContext.getBeansOfType(Bar.class);

        System.out.println(beansOfType1);
        System.out.println(beansOfType2);
        // output = {foo=com.java.spring_dasar.data.Foo@2072acb2, foo2=com.java.spring_dasar.data.Foo@50ecde95, foo3=com.java.spring_dasar.data.Foo@35a9782c}

    }
}

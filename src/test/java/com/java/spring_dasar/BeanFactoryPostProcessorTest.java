package com.java.spring_dasar;

import com.java.spring_dasar.data.Foo;
import com.java.spring_dasar.processor.FooBeanFactoryPostProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class BeanFactoryPostProcessorTest {

    @Configuration
    @Import({FooBeanFactoryPostProcessor.class})
    public static class TestBeanFactoryPostProcessorConfiguration{

    }

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setup (){
        applicationContext = new AnnotationConfigApplicationContext(TestBeanFactoryPostProcessorConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testBeanFactoryPostProcessor(){
        Foo foo = applicationContext.getBean(Foo.class);
        System.out.println(foo.getClass());
        Assertions.assertNotNull(foo);
    }
}

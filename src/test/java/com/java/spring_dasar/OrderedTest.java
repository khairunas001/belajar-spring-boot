package com.java.spring_dasar;

import com.java.spring_dasar.data.Car;
import com.java.spring_dasar.processor.IdGeneratorBeanPostProcessor;
import com.java.spring_dasar.processor.PrefixGeneratorBeanPostProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class OrderedTest {

    @Configuration
    @Import({Car.class, IdGeneratorBeanPostProcessor.class, PrefixGeneratorBeanPostProcessor.class})
    public static class TestOrderedConfiguration {

    }

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(TestOrderedConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testCar() {
        Car car = applicationContext.getBean(Car.class);

        Assertions.assertTrue(car.getId().startsWith("PZN-"));
        Assertions.assertNotNull(car.getId());

        System.out.println(car.getId());

    }

}

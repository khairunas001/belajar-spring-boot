package com.java.spring_dasar;

import com.java.spring_dasar.data.Car;
import com.java.spring_dasar.processor.IdGeneratorBeanPostProcessor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Slf4j
public class BeanPostProcessorTest {

    @Configuration
    @Import({Car.class, IdGeneratorBeanPostProcessor.class})
    public static class TestConfiguration {

    }

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setup(){
       applicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
       applicationContext.registerShutdownHook();
    }

    @Test
    void testBeanPostProcessor(){
        Car car = applicationContext.getBean(Car.class);

        System.out.println(car.getId());
        log.info("\nBeans who implemented IdAware : {}\n",car.getId());
        Assertions.assertNotNull(car.getId());

    }

}

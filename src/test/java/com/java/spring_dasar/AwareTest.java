package com.java.spring_dasar;

import com.java.spring_dasar.service.AuthService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class AwareTest {

    @Configuration
    @Import({AuthService.class})
    public static class TestAwareCOnfiguration {

    }

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(TestAwareCOnfiguration.class);
        applicationContext.registerShutdownHook();
    }


    @Test
    void testAware() {
        AuthService authService = applicationContext.getBean(AuthService.class);
        Assertions.assertEquals(AuthService.class.getName(), authService.getBeanName());
        System.out.println("dari pengujian nama beannnya adalah : " + AuthService.class.getName() + "\ndan dari variablea authService :" + authService.getBeanName() + "\nyang mana namanya identik");
        Assertions.assertSame(applicationContext, authService.getApplicationContext());
        System.out.println("dari untuk membandingkan nama applicationContext \ndengan yang ada pada authService sebagi berikut : " + authService.getApplicationContext());
    }
}

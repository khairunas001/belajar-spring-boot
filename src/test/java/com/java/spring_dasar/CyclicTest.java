package com.java.spring_dasar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CyclicTest {

//    akan terjadi circularity
//    @Test
//    void testCyclic(){
//
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CyclicConfiguration.class);
//
//    }

    @Test
    void testCyclic2() {
        Assertions.assertThrows(Throwable.class, () -> {
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CyclicConfiguration.class);
        });
    }

    @Test
    void testCyclic3() {
        Assertions.assertThrows(BeansException.class, () -> {
            new AnnotationConfigApplicationContext(CyclicConfiguration.class);
        });
    }

    @Test
    void testCyclic4() {
        try {
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CyclicConfiguration.class);
            Assertions.fail("It should fail due to cyclic dependency");
        } catch (BeansException exception) {
            // Validasi bahwa exception yang ditangkap memang karena circular dependency
            Assertions.assertTrue(
                    exception.getMessage().toLowerCase().contains("circular")
                            || exception instanceof org.springframework.beans.factory.BeanCurrentlyInCreationException,
                    "Expected cyclic dependency error"
            );
        }
    }
}

package com.java.spring_dasar;

import com.java.spring_dasar.service.MerchantService;
import com.java.spring_dasar.service.MerchantServiceImplementation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InheritanceTest {

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(InheritanceConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testInheritance() {
        MerchantService merchantService = applicationContext.getBean(MerchantService.class);
        MerchantServiceImplementation merchantServiceImplementation = applicationContext.getBean(MerchantServiceImplementation.class);

        // Harus sama karena kita bisa mengakses langsung dengan tipe class bean tersebut,
        // atau bisa juga dengan parent class / parent interface bean
        Assertions.assertSame(merchantService, merchantServiceImplementation);

    }
}

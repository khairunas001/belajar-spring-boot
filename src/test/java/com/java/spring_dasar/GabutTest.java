package com.java.spring_dasar;

import com.java.spring_dasar.data.Gabut;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GabutTest {

    @Test
    void testCreateGabut() {
        ApplicationContext contextTestGabut = new AnnotationConfigApplicationContext(GabutConfiguration.class);

        Assertions.assertNotNull(contextTestGabut);
    }

    @Test
    void testGetBeanGabut() {
        ApplicationContext contextTestGabut = new AnnotationConfigApplicationContext(GabutConfiguration.class);

        // bean merupakan singleton, artinya jika kita mengakses bean yang sama, maka dia akan mengembalikan object yang sama.
        Gabut gabut1 = contextTestGabut.getBean(Gabut.class);
        Gabut gabut2 = contextTestGabut.getBean(Gabut.class);

        Assertions.assertSame(gabut1, gabut2);
    }

}

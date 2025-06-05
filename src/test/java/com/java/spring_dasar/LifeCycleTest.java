package com.java.spring_dasar;

import com.java.spring_dasar.data.Connection;
import com.java.spring_dasar.data.Server;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeCycleTest {

    //    private ApplicationContext applicationContext;
    private ConfigurableApplicationContext configurableApplicationContext; // agar bisa menggunakan method close untuk menutup Bean

    @BeforeEach
    void setUp() {
        configurableApplicationContext = new AnnotationConfigApplicationContext(LifeCycleConfiguration.class);
        configurableApplicationContext.registerShutdownHook();
    }

    @AfterEach
    void tearDown() {
//        configurableApplicationContext.close(); // secara manual
    }


    @Test
    void testConnection() {
        // sebelumnya aku ada error di Bean Connection dimana
        // source yang bearada di "import java.sql.Connection;"
        // yang bukan Bean yang kubuat dan yang seharunya
        // adalah "import com.java.spring_dasar.data.Connection;"
        // file tempat bean yang kubuat
        Connection connection = configurableApplicationContext.getBean(Connection.class);
    }

    @Test
    void server() {
        Server server = configurableApplicationContext.getBean(Server.class);
    }

}

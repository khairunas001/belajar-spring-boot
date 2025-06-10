package com.java.spring_dasar;

import com.java.spring_dasar.listener.LoginAgainSuccesListener;
import com.java.spring_dasar.listener.LoginSuccesListener;
import com.java.spring_dasar.listener.UserListener;
import com.java.spring_dasar.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class testEventListener {

    @Configuration
    @Import({UserService.class, LoginSuccesListener.class, LoginAgainSuccesListener.class, UserListener.class})
    public static class TestEventListenerConfiguration{

    }

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp (){
     applicationContext = new AnnotationConfigApplicationContext(TestEventListenerConfiguration.class);
     applicationContext.registerShutdownHook();
    }

    @Test
    void testEventListener(){
        UserService userService = applicationContext.getBean(UserService.class);
        userService.login("joko","wiwok");
        userService.login("mulyadi","woowowo");
    }
}

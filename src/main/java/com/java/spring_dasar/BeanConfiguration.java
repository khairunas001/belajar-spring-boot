package com.java.spring_dasar;

import com.java.spring_dasar.data.Foo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class BeanConfiguration {
    private static final Logger log = LoggerFactory.getLogger(BeanConfiguration.class);

    @Bean //Beans Constructor
    public Foo foo(){
        Foo foo = new Foo();
        log.info("Create new Foo");
        return foo;
    }
}

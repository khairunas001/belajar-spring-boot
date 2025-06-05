package com.java.spring_dasar.configuration;

import com.java.spring_dasar.data.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class FooConfiguration {

    @Bean
    public Foo foo() {
        log.info("Created Foo");
        return new Foo();
    }

}

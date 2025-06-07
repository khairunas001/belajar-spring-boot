package com.java.spring_dasar.configuration;

import com.java.spring_dasar.data.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Slf4j
@Configuration
public class FooConfiguration {

    @Primary
    @Bean
    public Foo foo() {
        log.info("Created Foo");
        return new Foo();
    }

    @Bean
    public Foo foo2() {
        log.info("Created Foo");
        return new Foo();
    }

    @Bean
    public Foo foo3() {
        log.info("Created Foo");
        return new Foo();
    }

}

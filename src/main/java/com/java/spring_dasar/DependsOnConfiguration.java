package com.java.spring_dasar;

import com.java.spring_dasar.data.Bar;
import com.java.spring_dasar.data.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;

@Slf4j
@Configuration
public class DependsOnConfiguration {

    @Lazy // berguna agar Dean dipangggil ketika digunakan, maka saat start up Bean Foo tidak akan dibuat dahulu
    @Bean
    @DependsOn({
            "bar"
    })
    public Foo foo() {
        log.info("create new foo");
        return new Foo();
    }

    @Bean
    public Bar bar() {
        log.info("create new bar");
        return new Bar();
    }
}

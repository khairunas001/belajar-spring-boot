package com.java.spring_dasar.configuration;

import com.java.spring_dasar.data.Bar;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class BarConfiguration {

    @Bean
    public Bar bar() {
        log.info("Created Bar");
        return new Bar();
    }
}

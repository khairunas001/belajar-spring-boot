package com.java.spring_dasar;

import com.java.spring_dasar.configuration.BarConfiguration;
import com.java.spring_dasar.configuration.FooConfiguration;
import com.java.spring_dasar.data.Bar;
import com.java.spring_dasar.data.Foo;
import com.java.spring_dasar.data.FooBar;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Slf4j
@Configuration
@Import({FooConfiguration.class, BarConfiguration.class})
public class MainConfiguration {

    //gabut
    @Bean
    public FooBar fooBar(Foo foo, Bar bar){
        log.info("Created FooBar");
        return new FooBar(foo, bar);
    }
}

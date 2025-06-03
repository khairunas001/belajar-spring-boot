package com.java.spring_dasar;

import com.java.spring_dasar.data.Foo;
import org.springframework.context.annotation.Bean;

public class DuplicateConfiguration {

    @Bean
    public Foo foo1 (){
        return new Foo();
    }

    @Bean
    public Foo foo2 (){
        return new Foo();
    }
}

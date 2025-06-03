package com.java.spring_dasar;


import com.java.spring_dasar.data.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeanNameConfiguration {

    @Primary
    @Bean("fooFirst")
    public Foo foo1 (){
        return new Foo();
    }

    @Bean("fooSecond")
    public Foo foo2 (){
        return new Foo();
    }
}

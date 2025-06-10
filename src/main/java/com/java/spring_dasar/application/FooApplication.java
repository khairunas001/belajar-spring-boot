package com.java.spring_dasar.application;

import com.java.spring_dasar.data.Bar;
import com.java.spring_dasar.data.Foo;
import com.sun.tools.javac.Main;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FooApplication {

    // jika mencoba Failure Analyzer
//    @Bean
//    public Foo foo(Bar bar){
//        return new Foo();
//    }
    // akan mendapat pesan seperti ini
    //***************************
    //APPLICATION FAILED TO START
    //***************************
    //Description:
    //Parameter 0 of method foo in com.java.spring_dasar.application.FooApplication required a bean of type 'com.java.spring_dasar.data.Bar' that could not be found.

    //Action:
    //Consider defining a bean of type 'com.java.spring_dasar.data.Bar' in your configuration.

    @Bean
    public Foo foo() {
        return new Foo();
    }

//    public static void main(String[] args) {
//        ConfigurableApplicationContext applicationContext = SpringApplication.run(FooApplication.class, args);
//
//        Foo foo = applicationContext.getBean(Foo.class);
//
//        System.out.println(foo);
//    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(FooApplication.class);
        application.setBannerMode(Banner.Mode.OFF);

        ConfigurableApplicationContext applicationContext = application.run(args);

        Foo foo = applicationContext.getBean(Foo.class);
    }
}

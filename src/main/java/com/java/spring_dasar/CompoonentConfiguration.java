package com.java.spring_dasar;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"com.java.spring_dasar.service", "com.java.spring_dasar.repository", "com.java.spring_dasar.configuration"})

public class CompoonentConfiguration {


}

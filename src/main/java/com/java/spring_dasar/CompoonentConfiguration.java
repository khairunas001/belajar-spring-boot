package com.java.spring_dasar;


import com.java.spring_dasar.data.MultiFoo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(value = {"com.java.spring_dasar.service", "com.java.spring_dasar.repository", "com.java.spring_dasar.configuration"})
@Import(MultiFoo.class)

public class CompoonentConfiguration {


}

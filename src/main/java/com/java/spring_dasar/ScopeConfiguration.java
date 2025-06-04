package com.java.spring_dasar;

import com.java.spring_dasar.data.Bar;
import com.java.spring_dasar.data.Foo;
import com.java.spring_dasar.scope.Doubleton;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Slf4j
@Configuration
public class ScopeConfiguration {

    @Bean
    @Scope("prototype") // kode dibuat setiap dipanggil
//    @Scope("singleton") // kode dipanggil sekali ketika pertama kali dipanggil
    public Foo foo() {
        log.info("Create new Foo");
        return new Foo();
    }

    // bean untuk melakukan register configurasi scope yang dibuat
    @Bean
    public CustomScopeConfigurer customScopeConfigurer (){
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.addScope("doubleton", new Doubleton());
        return configurer;
    }

    @Bean
    @Scope("doubleton")
    public Bar bar (){
        log.info("Create new Bar");
        return new Bar();
    }

}

package com.java.spring_dasar;

import com.java.spring_dasar.data.Gabut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GabutConfiguration {

    private static final Logger log = LoggerFactory.getLogger(GabutConfiguration.class);

    @Bean //Beans Constructor
    public Gabut gabut(){
        Gabut gabut = new Gabut();
        log.info("Guabut AKU COYY");
        System.out.println("Gabut tenin");
        return gabut;
    }
}

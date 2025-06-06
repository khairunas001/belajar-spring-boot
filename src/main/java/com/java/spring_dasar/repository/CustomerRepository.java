package com.java.spring_dasar.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
//@Component
public class CustomerRepository {
    public CustomerRepository() {
        log.info("CustomerRepository has been created");
    }
}

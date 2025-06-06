package com.java.spring_dasar.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProductRepository {

    // jika ingin mengeluarkan log
    public ProductRepository() {
        log.info("ProductRepository has been created");
    }
}

package com.java.spring_dasar.service;

import com.java.spring_dasar.repository.ProductRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Lazy // akan dipanggil sekalio berapa banyak bean dipanggil
//@Scope("prototype") // akan dipanggil setiap bean dipanggil
@Slf4j
@Component
public class ProductService {

    @Getter
    private ProductRepository productRepository;


    // jika terdapat 2 constructure maka perlu menggunakan annotation @AutoWired untuk memberitahu constructure yang digunakan

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
        log.info("ProductService has been created");
    }

    public ProductService(ProductRepository productRepository, String name) {
        this.productRepository = productRepository;
        log.info("ProductService has been created");
    }

}

package com.java.spring_dasar.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CategoryRepository {
    public CategoryRepository(){
        log.info("CategoryService has been created");
    }
}

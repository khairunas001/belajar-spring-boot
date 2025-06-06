package com.java.spring_dasar.service;

import com.java.spring_dasar.repository.CategoryRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CategoryService {

    @Getter
    private CategoryRepository categoryRepository;

//    @Autowired
//    public CategoryService(CategoryRepository categoryRepository) {
//        this.categoryRepository = categoryRepository;
//        log.info("CategoryService has been created");
//    }

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
        log.info("CategoryService has been created");
    }
}

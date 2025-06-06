package com.java.spring_dasar;

import com.java.spring_dasar.repository.CategoryRepository;
import com.java.spring_dasar.repository.CustomerRepository;
import com.java.spring_dasar.repository.ProductRepository;
import com.java.spring_dasar.service.CategoryService;
import com.java.spring_dasar.service.CustomerService;
import com.java.spring_dasar.service.ProductService;
import org.junit.jupiter.api.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

public class ComponentTest {

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(CompoonentConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testComponent() {
        ProductService productService1 = applicationContext.getBean(ProductService.class);

        // karena menggunakana @ComponentScan maka nama beannya adalah productService
        // yang didapat dari nama class nya dengan menggunakan camelcase
        ProductService productService2 = applicationContext.getBean("productService", ProductService.class);

        Assertions.assertSame(productService1, productService2);
    }

    @Test
    void testConstructorDependencyInjection() {
        ProductService productService = applicationContext.getBean(ProductService.class);
        ProductRepository productRepository = applicationContext.getBean(ProductRepository.class);

        Assertions.assertNotNull(productService.getProductRepository());

        // harus sama karena menggunakan injection
        Assertions.assertSame(productService.getProductRepository(), productRepository);

    }

    @Test
    void testSetterDependencyInjection() {
        CategoryService categoryService = applicationContext.getBean(CategoryService.class);
        CategoryRepository categoryRepository = applicationContext.getBean(CategoryRepository.class);

        Assertions.assertNotNull(categoryService.getCategoryRepository());
        Assertions.assertSame(categoryService.getCategoryRepository(), categoryRepository);
    }

    @Test
    void testFieldDependencyInjection() {
        CustomerService customerService = applicationContext.getBean(CustomerService.class);
        CustomerRepository customerRepository = applicationContext.getBean(CustomerRepository.class);

        Assertions.assertNotNull(customerService.getCustomerRepository());
        Assertions.assertSame(customerService.getCustomerRepository(), customerRepository);
    }


    @Test
    void testQualifierDependencyInjection() {
        CustomerService customerService = applicationContext.getBean(CustomerService.class);
        CustomerRepository normalCustomerRepository = applicationContext.getBean("normalCustomerRepository", CustomerRepository.class);
        CustomerRepository premiumCustomerRepository = applicationContext.getBean("premiumCustomerRepository",CustomerRepository.class);

        Assertions.assertSame(normalCustomerRepository,customerService.getNormalCustomerRepository());
        Assertions.assertSame(premiumCustomerRepository,customerService.getPremiumCustomerRepository());
    }


}

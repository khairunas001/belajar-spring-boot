package com.java.spring_dasar.service;

import com.java.spring_dasar.repository.CustomerRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomerService {

    @Getter
    @Autowired
    private CustomerRepository customerRepository;

    @Getter
    @Autowired
    @Qualifier("normalCustomerRepository")
    private CustomerRepository normalCustomerRepository;

    @Getter
    @Autowired
    @Qualifier("premiumCustomerRepository")
    private CustomerRepository premiumCustomerRepository;

    public CustomerService() {
        log.info("CustomerRepository has been created");
    }

}

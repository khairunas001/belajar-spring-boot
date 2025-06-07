package com.java.spring_dasar;

import com.java.spring_dasar.service.MerchantServiceImplementation;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MerchantServiceImplementation.class)
public class InheritanceConfiguration {

}

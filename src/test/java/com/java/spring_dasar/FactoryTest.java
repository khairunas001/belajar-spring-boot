package com.java.spring_dasar;

import com.java.spring_dasar.client.PaymentGatewayClient;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class FactoryTest {

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(FactoryConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testFactory() {
        PaymentGatewayClient paymentGatewayClient = applicationContext.getBean(PaymentGatewayClient.class);

        Assertions.assertNotNull(paymentGatewayClient);
        Assertions.assertEquals("https://example.com", paymentGatewayClient.getEndpoint());
        log.info("✅ Test berhasil: PaymentGatewayClient diinisialisasi dengan endpoint {}", paymentGatewayClient.getEndpoint());
        Assertions.assertEquals("private", paymentGatewayClient.getPrivatekey());
        log.info("✅ Test berhasil: PaymentGatewayClient diinisialisasi dengan Private key {}", paymentGatewayClient.getPrivatekey());
        Assertions.assertEquals("public", paymentGatewayClient.getPublickey());
        log.info("✅ Test berhasil: PaymentGatewayClient diinisialisasi dengan Public key {}", paymentGatewayClient.getPublickey());
    }

}

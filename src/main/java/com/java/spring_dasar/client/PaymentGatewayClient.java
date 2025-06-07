package com.java.spring_dasar.client;

import lombok.Data;

@Data
public class PaymentGatewayClient {
    private String endpoint;

    private String privatekey;

    private String publickey;
}

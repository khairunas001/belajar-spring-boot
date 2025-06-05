package com.java.spring_dasar;

import com.java.spring_dasar.data.Connection;
import com.java.spring_dasar.data.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LifeCycleConfiguration {

    @Bean
    public Connection connection() {
        return new Connection();
    }
//    menggunakan ini jika tidak menggunakan anotasi " @PostConstruct" dan "@PreDestroy"
//    @Bean(initMethod = "start", destroyMethod = "stop")
//    public Server server(){
//        return new Server();
//    }

    @Bean
    public Server server() {
        return new Server();
    }

}
